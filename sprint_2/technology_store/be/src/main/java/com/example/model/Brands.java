package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brands")
    @JsonIgnore
    private Set<Product> productSet;

    public Brands() {
    }

    public Brands(Long id, String name, Set<Product> productSet) {
        this.id = id;
        this.name = name;
        this.productSet = productSet;
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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
