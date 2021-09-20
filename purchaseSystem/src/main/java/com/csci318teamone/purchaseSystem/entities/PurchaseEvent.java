package com.csci318teamone.purchaseSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PurchaseEvent {

  @Id
  @GeneratedValue
  private long id;

  @Column
  private String supplier;

  @Column
  private int quantity;

  @Column(name = "product")
  private String productRecord;

  @Column(name = "customer")
  private String customerRecord;

  public PurchaseEvent() {}

  public PurchaseEvent(Purchase purchase) {
    super();
    this.setSupplier(purchase.getsupplier());
    this.setQuantity(purchase.getquantity());
    this.setProductRecord(purchase.getProduct().toString());
    this.setCustomerRecord(purchase.getCustomer().toString());
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getProductRecord() {
    return productRecord;
  }

  public void setProductRecord(String productRecord) {
    this.productRecord = productRecord;
  }

  public String getCustomerRecord() {
    return customerRecord;
  }

  public void setCustomerRecord(String customerRecord) {
    this.customerRecord = customerRecord;
  }
}
