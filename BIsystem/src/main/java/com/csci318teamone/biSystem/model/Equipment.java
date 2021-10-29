package com.csci318teamone.biSystem.model;

public class Equipment {

  private String product;
  private String equipment;

  public Equipment() {}

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getEquipment() {
    return equipment;
  }

  public void setEquipment(String equipment) {
    this.equipment = equipment;
  }

  @Override
  public String toString() {
    return (
      "Equipment{" +
      "product='" +
      product +
      '\'' +
      ", equipment='" +
      equipment +
      '\'' +
      '}'
    );
  }
}
