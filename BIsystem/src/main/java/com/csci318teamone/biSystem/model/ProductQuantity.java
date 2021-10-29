package com.csci318teamone.biSystem.model;

public class ProductQuantity {

  private String name;
  private long quantity;

  public ProductQuantity() {}

  public ProductQuantity(String name, long quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return (
      "ProductQuantity{" +
      "name='" +
      name +
      '\'' +
      ", quantity=" +
      quantity +
      '}'
    );
  }
}
