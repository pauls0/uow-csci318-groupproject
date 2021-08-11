package com.csci318teamone.customerSystem.repositories;

import java.util.List;

import com.csci318teamone.customerSystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
