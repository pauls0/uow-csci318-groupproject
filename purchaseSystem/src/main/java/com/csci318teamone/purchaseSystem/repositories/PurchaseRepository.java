package com.csci318teamone.purchaseSystem.repositories;

import com.csci318teamone.purchaseSystem.entities.Purchase;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {}
