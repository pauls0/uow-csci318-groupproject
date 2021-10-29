package com.csci318teamone.biSystem.model;

public class Customer {

  private String product;
  private String customer;

  public Customer() {}

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return (
      "Customer{" +
      "product='" +
      product +
      '\'' +
      ", customer='" +
      customer +
      '\'' +
      '}'
    );
  }
}
