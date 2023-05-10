package com.example.applestore.model;

public class Category {
    private int idCategory;
    private int imgCategory;
    private String nameCategory;

    public Category(int idCategory, int imgCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.imgCategory = imgCategory;
        this.nameCategory = nameCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setImgCategory(int imgCategory) {
        this.imgCategory = imgCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public int getImgCategory() {
        return imgCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }
}
