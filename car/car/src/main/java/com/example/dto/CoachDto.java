package com.example.dto;

import com.example.model.CoachType;
import com.example.model.Location;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CoachDto implements Validator {
    @NotBlank
    private int id;

    @NotBlank
    private CoachType coachType;

    @NotBlank
    private String companyName;

    @NotBlank
    private Location departure;

    @NotBlank
    private Location destination;

    @NotBlank
    @Pattern(regexp = "^09[037]\\d{7}$")
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String departureTime;

    @NotBlank
    private String destinationTime;

    public CoachDto() {
    }

    public CoachDto(int id, CoachType coachType, String companyName, Location departure, Location destination, String phoneNumber, String email, String departureTime, String destinationTime) {
        this.id = id;
        this.coachType = coachType;
        this.companyName = companyName;
        this.departure = departure;
        this.destination = destination;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoachType getCoachType() {
        return coachType;
    }

    public void setCoachType(CoachType coachType) {
        this.coachType = coachType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Location getDeparture() {
        return departure;
    }

    public void setDeparture(Location departure) {
        this.departure = departure;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
