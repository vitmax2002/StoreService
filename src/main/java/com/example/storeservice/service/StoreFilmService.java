package com.example.storeservice.service;

import com.example.storeservice.repository.StoreFilmRepository;
import org.springframework.stereotype.Service;

@Service
public class StoreFilmService {

    private final StoreFilmRepository storeFilmRepository;

    public StoreFilmService(StoreFilmRepository storeFilmRepository) {
        this.storeFilmRepository = storeFilmRepository;
    }




}
