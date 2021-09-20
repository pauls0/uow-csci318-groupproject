package com.csci318teamone.purchaseSystem.services;

import com.csci318teamone.purchaseSystem.entities.Contact;
import com.csci318teamone.purchaseSystem.entities.Customer;
import com.csci318teamone.purchaseSystem.entities.Product;
import com.csci318teamone.purchaseSystem.entities.ProductDetail;
import com.csci318teamone.purchaseSystem.entities.Purchase;
import com.csci318teamone.purchaseSystem.entities.PurchaseTemplate;
import com.csci318teamone.purchaseSystem.repositories.PurchaseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PurchaseServiceImpl implements PurchaseService {

  @Autowired
  private WebClient.Builder webClientBuilder;

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
      .bodyToMono(Product.class)
      .block();

    return purchaseRepository.save(
      new Purchase(
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
      )
    );
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
