package com.example.storeservice.controller;

import com.example.storeservice.model.Customer;
import com.example.storeservice.model.Payment;
import com.example.storeservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> addPayment(@RequestBody Customer customer){
        Customer createdCustomer=customerService.addCustomer(customer);
        return ResponseEntity.ok().body(createdCustomer);
    }
}
