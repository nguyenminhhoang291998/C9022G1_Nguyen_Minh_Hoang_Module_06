package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Role {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<Employee> employeeSet;

    public Role() {
    }

    public Role(int id, String name, Set<Employee> employeeSet) {
        this.id = id;
        this.name = name;
        this.employeeSet = employeeSet;
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

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
