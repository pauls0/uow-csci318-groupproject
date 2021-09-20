package com.csci318teamone.productSystem.entities;

import javax.persistence.*;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String productCategory;
  private String name;
  private double price;
  private int stockQuantity;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn
  private ProductDetail productDetail;

  protected Product() {}

  public Product(
    String productCategory,
    String name,
    double price,
    int stockQuantity,
    ProductDetail productDetail
  ) {
    this.productCategory = productCategory;
    this.name = name;
    this.price = price;
    this.stockQuantity = stockQuantity;
    this.productDetail = productDetail;
  }

  @Override
  public String toString() {
    return String.format(
      "Product[id=%d, productCategory='%s', name='%s', price='%s', stockQuantity='%s', productDetail='%s']",
      id,
      productCategory,
      name,
      price,
      stockQuantity,
      productDetail
    );
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(int stockQuantity) {
    this.stockQuantity = stockQuantity;
  }

  public ProductDetail getProductDetail() {
    return productDetail;
  }

  public void setProductDetail(ProductDetail productDetail) {
    this.productDetail = productDetail;
  }
}
