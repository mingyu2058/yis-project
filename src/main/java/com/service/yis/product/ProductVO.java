package com.service.yis.product;

public class ProductVO {
    private int product_id;
    private String product_name;
    private String date1;
    private String date2;
    private int price;

    private int price1;
    private int price2;
    private String Imgsrc;

    private String johab;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

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

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public void setJohab(String johab) {
        this.johab = johab;
    }

    public String getJohab() {
        return johab;
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

    public int getPrice1() {
        return price1;
    }

    public int getPrice2() {
        return price2;
    }

}