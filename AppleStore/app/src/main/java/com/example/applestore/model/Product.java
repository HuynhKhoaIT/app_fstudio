package com.example.applestore.model;

import java.text.NumberFormat;
public class Product {
    private int id;
    private  int id_category;
    private String name;
    private int price;

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getPrice() {
        return price;
    }

    public int getInit_price() {
        return init_price;
    }

    public void setInit_price(int init_price) {
        this.init_price = init_price;
    }

    public int getSale_price() {
        return sale_price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }

    public String getDes_short() {
        return des_short;
    }

    public void setDes_short(String des_short) {
        this.des_short = des_short;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    private  int init_price;
    private int sale_price;

    private static String image;

    private int quantity;

    private String des;

    public Product(int id, int id_category, String name, int price, int init_price, int sale_price, String image, int quantity, String des, String des_short, int isdelete) {
        this.id = id;
        this.id_category = id_category;
        this.name = name;
        this.price = price;
        this.init_price = init_price;
        this.sale_price = sale_price;
        this.image = image;
        this.quantity = quantity;
        this.des = des;
        this.des_short = des_short;
        this.isdelete = isdelete;
    }

    private  String des_short;
    private  int isdelete;
    private NumberFormat format = NumberFormat.getCurrencyInstance();

    public Product(String image, String name, int price, int id, int quantity, String des) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
        this.des = des;
    }

    public static String getImage() {
        return image;
    }

    public void setImage(String image) {
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
