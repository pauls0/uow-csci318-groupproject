package com.csci318teamone.customerSystem.controllers;

import com.csci318teamone.customerSystem.entities.Customer;
import com.csci318teamone.customerSystem.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private CustomerService customerService;

  @Autowired
  public void setCustomerRepository(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  List<Customer> getCustomers() {
    return customerService.getCustomers();
  }

  @PostMapping
  Customer createCustomer(@RequestBody Customer newCustomer) {
    return customerService.createCustomer(newCustomer);
  }

  @GetMapping("{id}")
  Customer getCustomerById(@PathVariable Long id) {
    return customerService.getCustomerById(id);
  }

  @PutMapping("{id}")
  Customer updateCustomerById(@PathVariable Long id, @RequestBody Customer newCustomer) {
    return customerService.updateCustomerById(id, newCustomer);
  }

  @DeleteMapping("{id}")
  void deleteCustomerById(@PathVariable Long id) {
    customerService.deleteCustomerById(id);
  }
}
