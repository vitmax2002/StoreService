package com.example.storeservice.controller;

import com.example.storeservice.model.Payment;
import com.example.storeservice.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
        Payment createdPayment=paymentService.addPayment(payment);
        return ResponseEntity.ok().body(createdPayment);
    }


}
