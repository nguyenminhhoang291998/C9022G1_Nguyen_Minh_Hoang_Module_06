package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CenterDTO implements Validator {
    private String name;
    private String openingDate;

    private String address;

    public CenterDTO() {
    }

    public CenterDTO(String name, String openingDate, String address) {
        this.name = name;
        this.openingDate = openingDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
