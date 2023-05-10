package com.example.dto;

public interface IOrderDTO {
    Long getID();
    Long getOrderDetailId();
    String getDatePurchase();
    String getOrderCode();
    int getOrderedQuantity();
    Long getProductId();
    String getProductName();
    Double getTotalPrice();
    int getProductQuantity();
    int getTotalQuantity();
    Double getProductPrice();
    String getUrl();

}
