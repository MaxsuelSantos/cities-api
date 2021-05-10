package com.max.citiesapi.service;

import com.max.citiesapi.Entity.Country;
import com.max.citiesapi.dto.CountryDTO;
import com.max.citiesapi.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {

        this.countryRepository = countryRepository;
    }

    public Page<CountryDTO> findAll(Pageable pageable) {
        Page<Country> countries = countryRepository.findAll(pageable);
        return countries.map(CountryDTO::new);
    }

    public CountryDTO findByName(String name) {
            Country country = countryRepository.findByName(name);
            return new CountryDTO(country);
    }
}
