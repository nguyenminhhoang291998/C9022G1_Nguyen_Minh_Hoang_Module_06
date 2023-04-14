package com.example.model;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    private Long id;

    @Column(nullable = false, columnDefinition = "date")
    private String startDate;

    @Column(nullable = false, columnDefinition = "date")
    private String endDate;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "center_id",referencedColumnName = "id")
    private Center center;

    public Ticket() {
    }

    public Ticket(Long id, String startDate, String endDate, Customer customer, Center center) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.center = center;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }
}
