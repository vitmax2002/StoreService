package com.example.storeservice.feign;

import com.example.storeservice.model.Film;
import com.example.storeservice.model.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "MovieService",path = "/api/v1")
public interface MovieService {

    @GetMapping("/films")
    ResponseEntity<List<FilmDto>> getAllFilms(@RequestHeader(name = "Authorization") String authorization);

    @GetMapping("/films/{filmId}")
    ResponseEntity<Film> getFilmById(@RequestHeader(name = "Authorization") String authorization,@PathVariable(name = "filmId") int filmId);

    @PutMapping("/films/places/{filmId}")
    ResponseEntity<Film> changeNumberOfPlaces(@RequestHeader(name = "Authorization") String authorization,@PathVariable(name = "filmId") int filmId);

    @PostMapping("/authentication/authenticate")
    ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationDto authenticationDto);

    @PostMapping("/authentication/register")
     ResponseEntity<AuthenticationResponseDto> register(@RequestBody UserDto userDto);
}
