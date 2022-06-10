package com.service.yis.product;

import java.awt.*;

public class ProductVO {
    private int product_id;
    private String product_name;
    private String date;
    private int price;
    private int priceRange;

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceRange() {
        return priceRange;
    }
}