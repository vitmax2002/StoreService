package com.example.storeservice.controller;

import com.example.storeservice.feign.MovieService;
import com.example.storeservice.model.Token;
import com.example.storeservice.model.dto.AuthenticationDto;
import com.example.storeservice.model.dto.AuthenticationResponseDto;
import com.example.storeservice.model.dto.Film;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

 private final MovieService movieService;

    public AuthenticationController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationDto authenticationDto){
        Token.VALUE =movieService.authenticate(authenticationDto).getBody().token();
        return ResponseEntity.ok().body(movieService.authenticate(authenticationDto).getBody());
    }
}
