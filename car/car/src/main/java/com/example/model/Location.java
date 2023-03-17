package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
@Entity
public class Location {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "departure")
    @JsonIgnore
    private Set<Coach> coachSet;

    @OneToMany(mappedBy = "destination")
    @JsonIgnore
    private Set<Coach> coaches;

    public Location() {
    }

    public Location(int id, String name, Set<Coach> coachSet, Set<Coach> coaches) {
        this.id = id;
        this.name = name;
        this.coachSet = coachSet;
        this.coaches = coaches;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Coach> getCoachSet() {
        return coachSet;
    }

    public void setCoachSet(Set<Coach> coachSet) {
        this.coachSet = coachSet;
    }

    public Set<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(Set<Coach> coaches) {
        this.coaches = coaches;
    }
}
