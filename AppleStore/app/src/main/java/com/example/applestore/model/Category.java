package com.example.applestore.model;

public class Category {
    private int idCategory;

    public int getIdloaisanpham() {
        return idloaisanpham;
    }

    public void setIdloaisanpham(int idloaisanpham) {
        this.idloaisanpham = idloaisanpham;
    }

    private  int idloaisanpham;
    private static String imgCategory;
    private String nameCategory;

    public Category(int idCategory, String imgCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.imgCategory = imgCategory;
        this.nameCategory = nameCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setImgCategory(String imgCategory) {
        this.imgCategory = imgCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public static String getImgCategory() {
        return imgCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }
}
