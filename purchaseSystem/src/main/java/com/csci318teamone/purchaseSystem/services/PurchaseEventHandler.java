package com.csci318teamone.purchaseSystem.services;

import com.csci318teamone.purchaseSystem.entities.Product;
import com.csci318teamone.purchaseSystem.entities.PurchaseEvent;
import com.csci318teamone.purchaseSystem.repositories.PurchaseEventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PurchaseEventHandler {

  private static final Logger log = LoggerFactory.getLogger(
    PurchaseEventHandler.class
  );

  @Autowired
  private WebClient.Builder webClientBuilder;

  private final PurchaseEventRepository purchaseEventRepository;

  PurchaseEventHandler(PurchaseEventRepository purchaseEventRepository) {
    this.purchaseEventRepository = purchaseEventRepository;
  }

  @EventListener
  public void handle(PurchaseEvent purchaseEvent) {
    Integer purchaseQuantity = purchaseEvent.getQuantity();
    Integer inventoryQuantity = null;
    Integer newQuantity = null;
    Long productId = null;

    ObjectMapper objectMapper = new ObjectMapper();
    try {
      Product product = objectMapper.readValue(
        purchaseEvent.getProductRecord(),
        Product.class
      );
      inventoryQuantity = product.getStockQuantity();
      productId = product.getId();
    } catch (Exception e) {
      log.error("Error: " + e);
    }
    newQuantity = inventoryQuantity - purchaseQuantity;

    Product updatedProduct = webClientBuilder
      .build()
      .get()
      .uri("http://localhost:8082/products/" + productId)
      .retrieve()
      .onStatus(
        HttpStatus::is4xxClientError,
        error -> Mono.error(new RuntimeException("API not found"))
      )
      .onStatus(
        HttpStatus::is5xxServerError,
        error -> Mono.error(new RuntimeException("Server is not responding"))
      )
      .bodyToMono(Product.class)
      .block();

    updatedProduct.setStockQuantity(newQuantity);

    // Product responseProduct = webClientBuilder
    webClientBuilder
      .build()
      .put()
      .uri("http://localhost:8082/products/" + productId)
      .body(BodyInserters.fromObject(updatedProduct))
      .retrieve()
      .onStatus(
        HttpStatus::isError,
        error -> Mono.error(new RuntimeException("Other Error"))
      )
      .bodyToMono(Product.class)
      .block();
    // log.info("Updated product record: " + updatedProduct.toJSONString());
    // log.info("Updated product record response: " + presp);

    purchaseEventRepository.save(purchaseEvent);
  }
}
