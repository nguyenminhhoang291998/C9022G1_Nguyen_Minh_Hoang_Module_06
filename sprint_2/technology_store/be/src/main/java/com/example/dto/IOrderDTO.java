package com.example.dto;

public interface IOrderDTO {
    Long getID();
    Long getOrderDetailId();

    String getDatePurchase();

    String getOrderCode();

    int getOrderedQuantity();

    String getProductName();

    Double getProductPrice();

    String getUrl();

    Double getTotalPrice();
}
