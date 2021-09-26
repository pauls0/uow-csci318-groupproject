package com.csci318teamone.purchaseSystem.services;

import com.csci318teamone.purchaseSystem.entities.Contact;
import com.csci318teamone.purchaseSystem.entities.Customer;
import com.csci318teamone.purchaseSystem.entities.Product;
import com.csci318teamone.purchaseSystem.entities.ProductDetail;
import com.csci318teamone.purchaseSystem.entities.Purchase;
import com.csci318teamone.purchaseSystem.entities.PurchaseEvent;
import com.csci318teamone.purchaseSystem.entities.PurchaseTemplate;
import com.csci318teamone.purchaseSystem.exception.PurchaseNotFoundException;
import com.csci318teamone.purchaseSystem.repositories.PurchaseEventRepository;
import com.csci318teamone.purchaseSystem.repositories.PurchaseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PurchaseServiceImpl implements PurchaseService {

  private ApplicationEventPublisher publisher;

  @Autowired
  public void PurchaseService(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  @Autowired
  private WebClient.Builder webClientBuilder;

  private PurchaseRepository purchaseRepository;
  private PurchaseEventRepository purchaseEventRepository;

  @Autowired
  public void setPurchaseEventRepository(
    PurchaseEventRepository purchaseEventRepository
  ) {
    this.purchaseEventRepository = purchaseEventRepository;
  }

  @Autowired
  public void setPurchaseRepository(PurchaseRepository purchaseRepository) {
    this.purchaseRepository = purchaseRepository;
  }

  public List<PurchaseEvent> getPurchases() {
    return purchaseEventRepository.findAll();
  }

  public PurchaseEvent getPurchaseById(Long id) {
    return purchaseEventRepository.findById(id).orElseThrow(() -> new PurchaseNotFoundException("Customer not found"));
  }

  public Purchase createPurchase(Purchase purchase) {
    return purchaseRepository.save(purchase);
  }

  public Purchase createPurchaseFromTemplate(
    PurchaseTemplate purchaseTemplate
  ) {
    Customer customer = webClientBuilder
      .build()
      .get()
      .uri(
        "http://localhost:8081/customers/" + purchaseTemplate.getCustomerID()
      )
      .retrieve()
      .bodyToMono(Customer.class)
      .block();

    Product product = webClientBuilder
      .build()
      .get()
      .uri("http://localhost:8082/products/" + purchaseTemplate.getProductID())
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

    Purchase purchase = new Purchase(
      null,
      purchaseTemplate.getQuantity(),
      new Product(
        product.getProductCategory(),
        product.getName(),
        product.getPrice(),
        product.getStockQuantity(),
        new ProductDetail(
          product.getProductDetail().getDescription(),
          product.getProductDetail().getComment()
        )
      ),
      new Customer(
        customer.getCompanyName(),
        customer.getAddress(),
        customer.getCountry(),
        new Contact(
          customer.getContact().getName(),
          customer.getContact().getPhone(),
          customer.getContact().getEmail(),
          customer.getContact().getPosition()
        )
      )
    );
    Customer tempCustomer = purchase.getCustomer();
    tempCustomer.setId(customer.getId());
    purchase.setCustomer(tempCustomer);

    Product tempProduct = purchase.getProduct();
    tempProduct.setId(product.getId());
    purchase.setProduct(tempProduct);

    recordPurchase(purchase);
    return purchase;
  }

  public Purchase updatePurchaseById(Long id, Purchase newPurchase) {
    return purchaseRepository
      .findById(id)
      .map(
        purchase -> {
          purchase.setsupplier(newPurchase.getsupplier());
          purchase.setquantity(newPurchase.getquantity());
          purchase.setProduct(newPurchase.getProduct());
          purchase.setCustomer(newPurchase.getCustomer());
          return purchaseRepository.save(purchase);
        }
      )
      .orElseGet(
        () -> {
          newPurchase.setId(id);
          return purchaseRepository.save(newPurchase);
        }
      );
  }

  public void deletePurchaseById(Long id) {
    purchaseRepository.deleteById(id);
  }

  public Purchase recordPurchase(Purchase purchase) {
    PurchaseEvent purchaseEvent = new PurchaseEvent(purchase);
    publisher.publishEvent(purchaseEvent);
    return purchase;
  }
}
