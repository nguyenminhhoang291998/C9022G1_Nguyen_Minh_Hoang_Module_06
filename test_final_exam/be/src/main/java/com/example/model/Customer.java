package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Customer {
    @Id
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Oder> oderSet;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Oder> getOderSet() {
        return oderSet;
    }

    public void setOderSet(Set<Oder> oderSet) {
        this.oderSet = oderSet;
    }
}
