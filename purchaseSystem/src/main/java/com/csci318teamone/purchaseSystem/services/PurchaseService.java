package com.csci318teamone.purchaseSystem.services;

import com.csci318teamone.purchaseSystem.entities.Purchase;
import com.csci318teamone.purchaseSystem.entities.PurchaseTemplate;
import java.util.List;

public interface PurchaseService {
  List<Purchase> getPurchases();

  Purchase getPurchaseById(Long id);

  Purchase createPurchase(Purchase purchase);

  Purchase createPurchaseFromTemplate(PurchaseTemplate purchaseTemplate);

  Purchase updatePurchaseById(Long id, Purchase newPurchase);

  void deletePurchaseById(Long id);

  Purchase recordPurchase(Purchase purchase);
}
