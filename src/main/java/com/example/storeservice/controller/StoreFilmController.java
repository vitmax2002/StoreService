package com.example.storeservice.controller;

import com.example.storeservice.feign.MovieService;
import com.example.storeservice.model.StoreFilm;
import com.example.storeservice.model.Token;
import com.example.storeservice.model.dto.FilmDto;
import com.example.storeservice.model.dto.StoreFilmDto;
import com.example.storeservice.repository.StoreFilmRepository;
import com.example.storeservice.service.StoreFilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class StoreFilmController {

    private final StoreFilmRepository storeFilmRepository;
    private final StoreFilmService storeFilmService;
    private final MovieService movieService;

    public StoreFilmController(StoreFilmRepository storeFilmRepository, StoreFilmService storeFilmService, MovieService movieService) {
        this.storeFilmRepository = storeFilmRepository;
        this.storeFilmService = storeFilmService;
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<FilmDto>> getAllFilms(){
        List<FilmDto> films= movieService.getAllFilms("Bearer "+Token.VALUE).getBody();
        return ResponseEntity.ok().body(films);
    }

    @PostMapping
    public ResponseEntity<StoreFilm> rezervareLocuri(@RequestBody StoreFilmDto storeFilmDto){
        StoreFilm createrStoreFilm=storeFilmService.reservePlace(storeFilmDto);
        return ResponseEntity.ok().body(createrStoreFilm);
    }
}
