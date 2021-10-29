package com.csci318teamone.purchaseSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class PurchaseMessage {

  @Id
  private int id;

  private String product;
  private String equipment;
  private String total;

  public PurchaseMessage(
    int id,
    String product,
    String equipment,
    String total
  ) {
    this.id = id;
    this.product = product; //product
    this.equipment = equipment; //customer
    this.total = total;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getproduct() {
    return product;
  }

  public void setproduct(String product) {
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
      "id=" +
      id +
      ", product='" +
      product +
      '\'' +
      ", equipment='" +
      equipment +
      '\'' +
      ", total='" +
      total +
      '\'' +
      '}'
    );
  }
}
