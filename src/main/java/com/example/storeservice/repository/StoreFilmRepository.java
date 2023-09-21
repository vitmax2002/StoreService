package com.example.storeservice.repository;

import com.example.storeservice.model.StoreFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreFilmRepository extends JpaRepository<StoreFilm,Integer> {
}
