package com.csci318teamone.purchaseSystem.entities;

import javax.persistence.*;

@Entity
public class PurchaseTemplate {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long customerID;
  private Long productID;
  private int quantity;

  protected PurchaseTemplate() {}

  public PurchaseTemplate(Long customerID, Long productID, int quantity) {
    this.customerID = customerID;
    this.productID = productID;
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return (
      "PurchaseTemplate{" +
      "id=" +
      id +
      ", customerID=" +
      customerID +
      ", productID=" +
      productID +
      ", quantity=" +
      quantity +
      '}'
    );
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCustomerID() {
    return customerID;
  }

  public void setCustomerID(Long customerID) {
    this.customerID = customerID;
  }

  public Long getProductID() {
    return productID;
  }

  public void setProductID(Long productID) {
    this.productID = productID;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
