package com.example.storeservice.controller;

import com.example.storeservice.feign.MovieService;
import com.example.storeservice.model.Token;
import com.example.storeservice.model.dto.Film;
import com.example.storeservice.repository.StoreFilmRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/films")
public class StoreFilmController {

    private final StoreFilmRepository storeFilmRepository;
    private final MovieService movieService;

    public StoreFilmController(StoreFilmRepository storeFilmRepository, MovieService movieService) {
        this.storeFilmRepository = storeFilmRepository;
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms(){
        List<Film> films= movieService.getAllFilms(Token.VALUE).getBody();
        return ResponseEntity.ok().body(films);
    }
}
