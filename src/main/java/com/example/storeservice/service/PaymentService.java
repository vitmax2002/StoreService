package com.example.storeservice.service;

import com.example.storeservice.model.Payment;
import com.example.storeservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment){
        Payment createdPayment=paymentRepository.save(payment);
        return createdPayment;
    }


}
