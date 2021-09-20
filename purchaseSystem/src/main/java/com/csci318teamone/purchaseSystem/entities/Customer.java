package com.csci318teamone.purchaseSystem.entities;

import com.csci318teamone.purchaseSystem.entities.Contact;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
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

  public Customer() {}

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

  public Customer(Customer customer) {
    this.companyName = customer.getCompanyName();
    this.address = customer.getAddress();
    this.country = customer.getCountry();
    this.contact = customer.getContact();
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

  public String toJSONString() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.writeValueAsString(this);
    } catch (JsonProcessingException e) {
      return "";
    }
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
