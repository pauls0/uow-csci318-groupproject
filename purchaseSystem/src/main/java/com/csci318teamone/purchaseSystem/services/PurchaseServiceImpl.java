package com.csci318teamone.purchaseSystem.services;

import com.csci318teamone.purchaseSystem.entities.Purchase;
import com.csci318teamone.purchaseSystem.repositories.PurchaseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

  private PurchaseRepository purchaseRepository;

  @Autowired
  public void setPurchaseRepository(PurchaseRepository purchaseRepository) {
    this.purchaseRepository = purchaseRepository;
  }

  public List<Purchase> getPurchases() {
    return purchaseRepository.findAll();
  }

  public Purchase getPurchaseById(Long id) {
    return purchaseRepository.findById(id).orElse(null);
  }

  public Purchase createPurchase(Purchase purchase) {
    return purchaseRepository.save(purchase);
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
}
