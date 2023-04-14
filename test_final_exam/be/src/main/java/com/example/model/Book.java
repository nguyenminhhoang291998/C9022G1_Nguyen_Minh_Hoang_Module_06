package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Book {
    @Id
    private Long id;
    private String name;
    private String author;
    private String publishingCompany;
    private double price;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private Set<DetailOder> detailOderSet;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<DetailOder> getDetailOderSet() {
        return detailOderSet;
    }

    public void setDetailOderSet(Set<DetailOder> detailOderSet) {
        this.detailOderSet = detailOderSet;
    }
}
