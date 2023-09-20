package com.example.storeservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "store_film")
public class StoreFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Customer customer;
    private String filmName;
}
