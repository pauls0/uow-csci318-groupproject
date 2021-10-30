package com.csci318teamone.biSystem.controller;

import com.csci318teamone.biSystem.service.BICustomerQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BICustomerController {

  @Autowired
  BICustomerQuery biCustomerQuery;

  @GetMapping("/bi/customers/{customerId}/products")
  List<String> getProducts(@PathVariable String customerId) {
    return biCustomerQuery.getProducts(customerId);
  }

  @GetMapping("/bi/customers/{customerId}/total")
  long getTotalOrdersValue(@PathVariable String customerId) {
    return biCustomerQuery.getTotalOrdersValue(customerId);
  }
}
