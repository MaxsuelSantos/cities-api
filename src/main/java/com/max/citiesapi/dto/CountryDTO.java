package com.max.citiesapi.dto;

import com.max.citiesapi.Entity.Country;

import javax.persistence.Column;

public class CountryDTO {

    private Long id;

    private String name;

    private String portugueseName;

    private String code;

    private Integer bacen;

    public CountryDTO() {
    }

    public CountryDTO(Country country) {
        id = country.getId();
        name = country.getName();
        portugueseName = country.getPortugueseName();
        code = country.getCode();
        bacen = country.getBacen();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPortugueseName() {
        return portugueseName;
    }

    public String getCode() {
        return code;
    }

    public Integer getBacen() {
        return bacen;
    }
}
