package com.example.model;

import javax.persistence.*;

@Entity
public class Coach {
    @Id
    @Column(name = "number_plate")
    private int id;

    @ManyToOne
    @JoinColumn(name = "coach_type_id", referencedColumnName = "id")
    private CoachType coachType;

    private String companyName;

    @ManyToOne
    @JoinColumn(name = "departure_id", referencedColumnName = "id")
    private Location departure;

    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "id")
    private Location destination;

    private String phoneNumber;
    private String email;
    private String departureTime;
    private String destinationTime;
    private boolean isDelete;

    public Coach() {
    }

    public Coach(int id, CoachType coachType, String companyName, Location departure, Location destination, String phoneNumber, String email, String departureTime, String destinationTime, boolean isDelete) {
        this.id = id;
        this.coachType = coachType;
        this.companyName = companyName;
        this.departure = departure;
        this.destination = destination;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
        this.isDelete = isDelete;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
