package com.example.storeservice.controller;

import com.example.storeservice.feign.MovieService;
import com.example.storeservice.model.Token;
import com.example.storeservice.model.dto.AuthenticationDto;
import com.example.storeservice.model.dto.AuthenticationResponseDto;
import com.example.storeservice.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

 private final MovieService movieService;

    public AuthenticationController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationDto authenticationDto){
       AuthenticationResponseDto authenticationResponseDto= movieService.authenticate(authenticationDto).getBody();
        Token.VALUE =authenticationResponseDto.token();
        return ResponseEntity.ok().body(authenticationResponseDto);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserDto userDto){
        Token.VALUE =movieService.register(userDto).getBody().token();
        return ResponseEntity.noContent().build();
        }
    }

