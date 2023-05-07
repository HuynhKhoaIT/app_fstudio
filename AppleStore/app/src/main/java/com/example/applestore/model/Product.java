package com.example.applestore.model;

import java.text.NumberFormat;
public class Product {
    private int image;
    private String name;
    private int price;
    private NumberFormat format = NumberFormat.getCurrencyInstance();

    public Product(int image, String name, int price) {
        this.image = image;
        this.name = name;
        this.price = price;
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
}
