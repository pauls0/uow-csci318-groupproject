package com.csci318teamone.customerSystem.entities;

import javax.persistence.*;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String companyName;
  private String address;
  private String country;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn
  private Contact contact;

  protected Customer() {}

  public Customer(
    String companyName,
    String address,
    String country,
    Contact contact
  ) {
    this.companyName = companyName;
    this.address = address;
    this.country = country;
    this.contact = contact;
  }

  @Override
  public String toString() {
    return String.format(
      "Customer[id=%d, companyName='%s', address='%s', country='%s', contact='%s']",
      id,
      companyName,
      address,
      country,
      contact
    );
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }
}
