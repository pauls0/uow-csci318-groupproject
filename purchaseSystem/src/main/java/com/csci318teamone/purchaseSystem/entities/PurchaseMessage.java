package com.csci318teamone.purchaseSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class PurchaseMessage {

  @Id
  private int id;

  private String brand;
  private String equipment;
  private String total;

  public PurchaseMessage(int id, String brand, String equipment, String total) {
    this.id = id;
    this.brand = brand; //product
    this.equipment = equipment; //customer
    this.total = total;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
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
      ", brand='" +
      brand +
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
