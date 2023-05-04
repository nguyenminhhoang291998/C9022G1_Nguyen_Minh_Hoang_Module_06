package com.example.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(nullable = false,columnDefinition = "date")
    private String releaseDate;

    @Column(nullable = false)
    private int productQuantity;

    @ManyToOne
    @JoinColumn(name = "product_type_id",referencedColumnName = "id")
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "brands_id",referencedColumnName = "id")
    private Brands brands;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<OrderDetail> orderDetailSet;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Image> imageSet;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String name, Double price, String description, String releaseDate, int productQuantity, ProductType productType, Brands brands, Set<OrderDetail> orderDetailSet, Set<Image> imageSet) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
        this.productQuantity = productQuantity;
        this.productType = productType;
        this.brands = brands;
        this.orderDetailSet = orderDetailSet;
        this.imageSet = imageSet;
    }

    public Set<Image> getImageSet() {
        return imageSet;
    }

    public void setImageSet(Set<Image> imageSet) {
        this.imageSet = imageSet;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }
}
