package com.csci318teamone.customerSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String phone;
  private String email;
  private String position;

  protected Contact() {}

  public Contact(String name, String phone, String email, String position) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.position = position;
  }

  @Override
  public String toString() {
    return String.format(
      "Contact[id=%d, name='%s', phone='%s', email='%s', position='%s']",
      id,
      name,
      phone,
      email,
      position
    );
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }
}
