package com.csci318teamone.purchaseSystem.services;

import com.csci318teamone.purchaseSystem.entities.PurchaseEvent;
import com.csci318teamone.purchaseSystem.repositories.PurchaseEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PurchaseEventHandler {

  @Autowired
  private WebClient.Builder webClientBuilder;

  private final PurchaseEventRepository purchaseEventRepository;

  PurchaseEventHandler(PurchaseEventRepository purchaseEventRepository) {
    this.purchaseEventRepository = purchaseEventRepository;
  }

  @EventListener
  public void handle(PurchaseEvent purchaseEvent) {
    purchaseEventRepository.save(purchaseEvent);
    // TODO: make request to update product quantity
  }
}
