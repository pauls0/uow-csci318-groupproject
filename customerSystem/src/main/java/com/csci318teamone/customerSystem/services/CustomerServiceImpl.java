package com.csci318teamone.customerSystem.services;

import com.csci318teamone.customerSystem.entities.Customer;
import com.csci318teamone.customerSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomerById(Long id, Customer newCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setCompanyName(newCustomer.getCompanyName());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setCountry(newCustomer.getCountry());
                    customer.setContact(newCustomer.getContact());
                    return customerRepository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return customerRepository.save(newCustomer);
                });
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
