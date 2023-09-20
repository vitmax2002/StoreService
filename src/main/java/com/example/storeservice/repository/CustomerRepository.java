package com.example.storeservice.repository;

import com.example.storeservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
