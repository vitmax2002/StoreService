package com.example.storeservice.feign;

import com.example.storeservice.model.dto.AuthenticationDto;
import com.example.storeservice.model.dto.AuthenticationResponseDto;
import com.example.storeservice.model.dto.Film;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "https://MovieService",path = "/api/v1")
public interface MovieService {

    @GetMapping("/films")
    ResponseEntity<List<Film>> getAllFilms(@RequestHeader(name = "Authorization") String authorization);

    @PostMapping("/authentication/authenticate")
    ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationDto authenticationDto);
}
