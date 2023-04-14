package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String openingDate;

    private String address;

    private boolean isDelete;

    @OneToMany(mappedBy = "center")
    @JsonIgnore
    private Set<Employee> employeeSet;

    @OneToMany(mappedBy = "center")
    @JsonIgnore
    private Set<Ticket> ticketSet;

    public Center() {
    }

    public Center(Long id, String name, String openingDate, String address, boolean isDelete, Set<Employee> employeeSet, Set<Ticket> ticketSet) {
        this.id = id;
        this.name = name;
        this.openingDate = openingDate;
        this.address = address;
        this.isDelete = isDelete;
        this.employeeSet = employeeSet;
        this.ticketSet = ticketSet;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
