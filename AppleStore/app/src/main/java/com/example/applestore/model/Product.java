package com.example.applestore.model;

import java.text.NumberFormat;
public class Product {
    private int image;
    private String name;
    private int price;

    private int id;

    private int quantity;

    private String des;
    private NumberFormat format = NumberFormat.getCurrencyInstance();

    public Product(int image, String name, int price, int id, int quantity, String des) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
        this.des = des;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceString() {
        return format.format(price);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDes() {
        return des;
    }
}
