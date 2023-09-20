package com.example.storeservice.repository;

import com.example.storeservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
