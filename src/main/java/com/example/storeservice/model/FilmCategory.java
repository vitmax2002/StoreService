package com.example.storeservice.model;

import jakarta.persistence.*;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


public class FilmCategory implements Serializable {


    private int filmCategoryId;


    private Film film;


    private Category category;

    private LocalDateTime lastUpdate;

    public FilmCategory() {
    }

    public FilmCategory(Film film, Category category, LocalDateTime lastUpdate) {
        this.film = film;
        this.category = category;
        this.lastUpdate = lastUpdate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getFilmCategoryId() {
        return filmCategoryId;
    }

    public void setFilmCategoryId(int filmCategoryId) {
        this.filmCategoryId = filmCategoryId;
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
        FilmCategory that = (FilmCategory) o;
        return filmCategoryId == that.filmCategoryId && Objects.equals(film, that.film) && Objects.equals(category, that.category) && Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmCategoryId, film, category, lastUpdate);
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "filmCategoryId=" + filmCategoryId +
                ", film=" + film +
                ", category=" + category +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
