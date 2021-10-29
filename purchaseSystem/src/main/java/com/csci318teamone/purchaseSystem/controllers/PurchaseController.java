package com.csci318teamone.purchaseSystem.controllers;

import com.csci318teamone.purchaseSystem.entities.Purchase;
import com.csci318teamone.purchaseSystem.entities.PurchaseEvent;
import com.csci318teamone.purchaseSystem.entities.PurchaseTemplate;
import com.csci318teamone.purchaseSystem.services.PurchaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

  private PurchaseService purchaseService;

  @Autowired
  public void setPurchaseRepository(PurchaseService purchaseService) {
    this.purchaseService = purchaseService;
  }

  @GetMapping
  List<PurchaseEvent> getPurchases() {
    return purchaseService.getPurchases();
  }

  @PostMapping("{new}")
  Purchase createPurchase(@RequestBody Purchase newPurchase) {
    return purchaseService.createPurchase(newPurchase);
  }

  @PostMapping
  Purchase createPurchaseFromTemplate(
    @RequestBody PurchaseTemplate newPurchaseTemplate
  ) {
    return purchaseService.createPurchaseFromTemplate(newPurchaseTemplate);
  }

  @GetMapping("{id}")
  PurchaseEvent getPurchaseById(@PathVariable Long id) {
    return purchaseService.getPurchaseById(id);
  }

  @PutMapping("{id}")
  Purchase updatePurchaseById(
    @PathVariable Long id,
    @RequestBody Purchase newPurchase
  ) {
    return purchaseService.updatePurchaseById(id, newPurchase);
  }

  @DeleteMapping("{id}")
  void deletePurchaseById(@PathVariable Long id) {
    purchaseService.deletePurchaseById(id);
  }
}
