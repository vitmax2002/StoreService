package com.example.storeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Actor implements Serializable {


    private int actorId;

    private String firstName;

    private String lastName;


    private List<Film> films;

    public Actor() {
    }

    public Actor(String firstName, String lastName, List<Film> films) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.films = films;
    }

    @JsonIgnore
    public List<Film> getFilms() {
        return films;
    }

    @JsonProperty
    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return actorId == actor.actorId && Objects.equals(firstName, actor.firstName) && Objects.equals(lastName, actor.lastName) && Objects.equals(films, actor.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName, films);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", films=" + films +
                '}';
    }
}
