package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class CoachType {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "coachType")
    @JsonIgnore
    private Set<Coach> coachSet;

    public CoachType() {
    }

    public CoachType(int id, String name, Set<Coach> coachSet) {
        this.id = id;
        this.name = name;
        this.coachSet = coachSet;
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
}
