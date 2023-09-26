package com.example.storeservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    private LocalDate birthday;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Payment payment;

    public Customer(String firstName, String lastName, LocalDate birthday, Payment payment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.payment = payment;
    }

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
