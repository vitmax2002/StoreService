package com.example.storeservice.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "store_film")
public class StoreFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Customer customer;
    private Film film;

    public StoreFilm() {
    }

    public StoreFilm(Customer customer, Film film) {
        this.customer = customer;
        this.film = film;
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreFilm storeFilm = (StoreFilm) o;
        return id == storeFilm.id && Objects.equals(customer, storeFilm.customer) && Objects.equals(film, storeFilm.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, film);
    }

    @Override
    public String toString() {
        return "StoreFilm{" +
                "id=" + id +
                ", customer=" + customer +
                ", film=" + film +
                '}';
    }
}
