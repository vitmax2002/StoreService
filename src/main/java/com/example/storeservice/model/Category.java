package com.example.storeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Category implements Serializable {


    private int categoryId;

    private String name;


    private List<FilmCategory> filmCategories;

    public Category() {
    }

    public Category(String name, List<FilmCategory> filmCategories) {
        this.name = name;
        this.filmCategories = filmCategories;
    }


    public List<FilmCategory> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(List<FilmCategory> filmCategories) {
        this.filmCategories = filmCategories;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId && Objects.equals(name, category.name) && Objects.equals(filmCategories, category.filmCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, filmCategories);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", filmCategories=" + filmCategories +
                '}';
    }
}
