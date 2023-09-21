package com.example.storeservice.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "store_film")
public class StoreFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Customer customer;
    private String filmName;

    public StoreFilm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreFilm storeFilm = (StoreFilm) o;
        return id == storeFilm.id && Objects.equals(customer, storeFilm.customer) && Objects.equals(filmName, storeFilm.filmName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, filmName);
    }

    @Override
    public String toString() {
        return "StoreFilm{" +
                "id=" + id +
                ", customer=" + customer +
                ", filmName='" + filmName + '\'' +
                '}';
    }
}
