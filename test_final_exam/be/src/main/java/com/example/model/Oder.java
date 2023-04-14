package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Oder {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @Column(columnDefinition = "date")
    private String oderDate;

    private double totalPrice;

    @OneToMany(mappedBy = "oder")
    @JsonIgnore
    private Set<DetailOder> detailOderSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOderDate() {
        return oderDate;
    }

    public void setOderDate(String oderDate) {
        this.oderDate = oderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<DetailOder> getDetailOderSet() {
        return detailOderSet;
    }

    public void setDetailOderSet(Set<DetailOder> detailOderSet) {
        this.detailOderSet = detailOderSet;
    }
}
