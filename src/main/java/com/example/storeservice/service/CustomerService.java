package com.example.storeservice.service;

import com.example.storeservice.model.Customer;
import com.example.storeservice.model.Payment;
import com.example.storeservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){
        Customer createdCustomer=customerRepository.save(customer);
        return createdCustomer;
    }
}
