package com.example.storeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Film implements Serializable {

    private int filmId;

    private String title;

    private Year year;


    private int length;

    private int places;

    @Enumerated(EnumType.STRING)
    private Rating rating;


    private List<FilmCategory> filmCategories;


    private List<Language> languages;


    private List<Actor> actors=new ArrayList<>();

    public Film() {
    }

    public Film(String title, Year year, int length, int places, Rating rating, List<FilmCategory> filmCategories, List<Language> languages, List<Actor> actors) {
        this.title = title;
        this.year = year;
        this.length = length;
        this.places = places;
        this.rating = rating;
        this.filmCategories = filmCategories;
        this.languages = languages;
        this.actors = actors;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<FilmCategory> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(List<FilmCategory> filmCategories) {
        this.filmCategories = filmCategories;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmId == film.filmId && length == film.length && places == film.places && Objects.equals(title, film.title) && Objects.equals(year, film.year) && rating == film.rating && Objects.equals(filmCategories, film.filmCategories) && Objects.equals(languages, film.languages) && Objects.equals(actors, film.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, year, length, places, rating, filmCategories, languages, actors);
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", length=" + length +
                ", places=" + places +
                ", rating=" + rating +
                ", filmCategories=" + filmCategories +
                ", languages=" + languages +
                ", actors=" + actors +
                '}';
    }
}
