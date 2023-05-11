package com.example.applestore.model;

public class Cart {
    private int MaGH;
    private int MaKH;
    private int IsDelete;

    public Cart() {
    }

    public Cart(int maGH, int maKH, int isDelete) {
        MaGH = maGH;
        MaKH = maKH;
        IsDelete = isDelete;
    }

    public int getMaGH() {
        return MaGH;
    }

    public void setMaGH(int maGH) {
        MaGH = maGH;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public int getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(int isDelete) {
        IsDelete = isDelete;
    }
}
