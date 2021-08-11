package com.csci318teamone.customerSystem.services;

import com.csci318teamone.customerSystem.entities.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomerById(Long id);

    Customer createCustomer(Customer Customer);

    Customer updateCustomerById(Long id, Customer newCustomer);

    void deleteCustomerById(Long id);
}
