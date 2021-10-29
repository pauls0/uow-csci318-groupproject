package com.csci318teamone.biSystem.controller;

import com.csci318teamone.biSystem.service.ProductInteractiveQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductQueryController {

  @Autowired
  ProductInteractiveQuery productInteractiveQuery;

  // use case 10 - return total order quantity for a product
  @GetMapping("/bi/product/{productName}/quantity")
  long getProductQuantityByName(@PathVariable String productName) {
    return productInteractiveQuery.getProductQuantity(productName);
  }
}
