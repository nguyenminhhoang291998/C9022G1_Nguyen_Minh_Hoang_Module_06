package com.example.dto;

public interface IProductDTO {
    Long getId();
    String getName();
    Double getPrice();
    String getDescription();
    String getReleaseDate();
    int getProductQuantity();
    Long getProductTypeId();
    String getProductTypeName();
    Long getBrandsId();
    String getBrandsName();
    String getUrl();
}
