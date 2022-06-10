package com.service.yis.product;

import java.awt.*;

public class ProductVO {
    private int product_id;
    private String product_name;
    private String date1;
    private String date2;
    private int price;
    private int priceRange;
    private String Imgsrc;

    public void setImgsrc(String imgsrc) {
        this.Imgsrc = imgsrc;
    }

    public String getImgsrc() {
        return Imgsrc;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public void setDate1(String date1) {
        this.date1 = date1;
    }
    public void setDate2(String date2) {
        this.date2 = date2;
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
    public String getDate1() {
        return date1;
    }
    public String getDate2() {
        return date2;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceRange() {
        return priceRange;
    }
}