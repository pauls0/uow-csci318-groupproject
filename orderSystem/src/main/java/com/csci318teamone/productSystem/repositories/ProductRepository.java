package com.csci318teamone.productSystem.repositories;

import com.csci318teamone.productSystem.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
