package com.csci318teamone.purchaseSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class PurchaseMessage {

  @Id
  private int id;

  private String product;
  private String customer;
  private String total;

  public PurchaseMessage(
    int id,
    String product,
    String customer,
    String total
  ) {
    this.id = id;
    this.product = product; //product
    this.customer = customer; //customer
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

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
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
      ", customer='" +
      customer +
      '\'' +
      ", total='" +
      total +
      '\'' +
      '}'
    );
  }
}
