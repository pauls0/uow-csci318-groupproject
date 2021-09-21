package com.csci318teamone.purchaseSystem.entities;

import javax.persistence.*;

@Entity
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String supplier;
  private int quantity;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn
  private Product product;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn
  private Customer customer;

  protected Purchase() {}

  public Purchase(String supplier, int quantity, Product product, Customer customer) {
    this.supplier = supplier;
    this.quantity = quantity;
    this.product = product;
    this.customer = customer;
  }

  @Override
  public String toString() {
    return String.format(
      "Purchase{supplier='%s', quantity=%d, product=%s, customer=%s}",
      supplier,
      quantity,
      product,
      customer
    );
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getsupplier() {
    return supplier;
  }

  public void setsupplier(String supplier) {
    this.supplier = supplier;
  }

  public int getquantity() {
    return quantity;
  }

  public void setquantity(int quantity) {
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
