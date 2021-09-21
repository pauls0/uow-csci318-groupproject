package com.csci318teamone.purchaseSystem.repositories;

import com.csci318teamone.purchaseSystem.entities.PurchaseEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseEventRepository extends JpaRepository<PurchaseEvent, Long> {}
