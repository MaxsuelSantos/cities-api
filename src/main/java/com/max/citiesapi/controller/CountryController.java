package com.max.citiesapi.controller;

import com.max.citiesapi.dto.CountryDTO;
import com.max.citiesapi.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<Page<CountryDTO>> findAll(Pageable pageable) {
        Page<CountryDTO> countriesDTO = countryService.findAll(pageable);
        return ResponseEntity.ok(countriesDTO);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CountryDTO> findByName(@PathVariable String name) {
        try {
            CountryDTO countryDTO = countryService.findByName(name);
            return ResponseEntity.ok(countryDTO);
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
