package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
    @Id
    private Long id;
    private String name;
    private String idCard;
    private String dayOfBirth;
    private boolean gender;


    @OneToOne(mappedBy = "customer")
    @JsonIgnore
    private Ticket ticket;

    public Customer() {
    }

    public Customer(Long id, String name, String idCard, String dayOfBirth, boolean gender, Ticket ticket) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.ticket = ticket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
