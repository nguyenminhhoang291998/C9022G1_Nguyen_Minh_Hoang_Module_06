package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String orderCode;

    @Column(columnDefinition = "date", nullable = false)
    private String datePurchase;

    private Double totalPay;

    private boolean isPaid;

    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person person;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderDetail> orderDetailSet;


    public Order() {
    }

    public Order(String datePurchase, Person person,String orderCode) {
        this.orderCode = orderCode;
        this.datePurchase = datePurchase;
        this.person = person;
    }

    public Order(Long id, String orderCode, String datePurchase, Double totalPay, boolean isPaid, Long employeeId, Person person, Set<OrderDetail> orderDetailSet) {
        this.id = id;
        this.orderCode = orderCode;
        this.datePurchase = datePurchase;
        this.totalPay = totalPay;
        this.isPaid = isPaid;
        this.employeeId = employeeId;
        this.person = person;
        this.orderDetailSet = orderDetailSet;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }


    public Person getCustomer() {
        return person;
    }

    public void setCustomer(Person person) {
        this.person = person;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }
}
