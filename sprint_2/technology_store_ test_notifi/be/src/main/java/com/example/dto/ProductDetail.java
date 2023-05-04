package com.example.dto;

import com.example.model.Image;
import com.example.model.Product;

import java.util.List;

public class ProductDetail {
    Product product;
    List<Image> imageList;

    public ProductDetail() {
    }

    public ProductDetail(Product product, List<Image> imageList) {
        this.product = product;
        this.imageList = imageList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
