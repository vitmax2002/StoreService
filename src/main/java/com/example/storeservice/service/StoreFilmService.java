package com.example.storeservice.service;

import com.example.storeservice.feign.MovieService;
import com.example.storeservice.model.Customer;
import com.example.storeservice.model.Film;
import com.example.storeservice.model.StoreFilm;
import com.example.storeservice.model.Token;
import com.example.storeservice.model.dto.StoreFilmDto;
import com.example.storeservice.repository.CustomerRepository;
import com.example.storeservice.repository.StoreFilmRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StoreFilmService {

    private final StoreFilmRepository storeFilmRepository;
    private final CustomerRepository customerRepository;
    private final MovieService movieService;

    public StoreFilmService(StoreFilmRepository storeFilmRepository, CustomerRepository customerRepository, MovieService movieService) {
        this.storeFilmRepository = storeFilmRepository;
        this.customerRepository = customerRepository;
        this.movieService = movieService;
    }


    public StoreFilm reservePlace(StoreFilmDto storeFilmDto) {
        StoreFilm storeFilm = new StoreFilm();
        Customer customer = customerRepository.findById(storeFilmDto.customer()).orElseThrow(()->new NoSuchElementException("Nu este customer cu id: "+storeFilmDto.customer()));
        if(movieService.getFilmById("Bearer "+ Token.VALUE, storeFilmDto.film()).getBody().getPlaces()!=0){
            Film film=movieService.getFilmById("Bearer "+ Token.VALUE, storeFilmDto.film()).getBody();
            film.setPlaces(film.getPlaces()-1);
            movieService.changeNumberOfPlaces("Bearer "+Token.VALUE,storeFilmDto.film());
            storeFilm.setFilm(film);
            storeFilm.setCustomer(customer);
            storeFilmRepository.save(storeFilm);
        }
        else throw new NoSuchElementException("Nu mai sunt locuri pentru filmul cu id: "+storeFilmDto.film());
        return storeFilm;
    }

}
