package com.example.storeservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double amount;
    @Enumerated(EnumType.STRING)
    private Type type;

    public Payment() {
    }

    public Payment(Double amount, Type type) {
        this.amount = amount;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
