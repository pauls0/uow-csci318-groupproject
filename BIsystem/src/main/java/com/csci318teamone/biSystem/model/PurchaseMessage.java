package com.csci318teamone.biSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseMessage {

  private int id;
  private String product;
  private String equipment;
  private String total;

  public PurchaseMessage() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return (
      "PurchaseMessage{" +
      "id='" +
      id +
      '\'' +
      ", product=" +
      product +
      ", equipment=" +
      equipment +
      ", total=" +
      total +
      '}'
    );
  }
}
