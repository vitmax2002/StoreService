package com.example.storeservice.model.dto;

import java.time.Year;

public record Film(String title,
                   Year year,
                   int length,
                   int places) {
}
