package com.csci318teamone.purchaseSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String description;
  private String comment;

  protected ProductDetail() {}

  public ProductDetail(String description, String comment) {
    this.description = description;
    this.comment = comment;
  }

  @Override
  public String toString() {
    return String.format("ProductDetail[id=%d, description='%s', comment='%s']", id, description, comment);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
