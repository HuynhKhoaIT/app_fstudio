package com.example.applestore.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    @SerializedName("maGH")
    int maGH;
    @SerializedName("khachHang")
    private User khachHang;
    @SerializedName("chiTietGioHangs")
    private List<CartDetail> chiTietGioHangs;
    @SerializedName("isDelete")
    int isDelete;

    public Cart() {
    }

    public Cart(int maGH, User khachHang, List<CartDetail> chiTietGioHangs, int isDelete) {
        this.maGH = maGH;
        this.khachHang = khachHang;
        this.chiTietGioHangs = chiTietGioHangs;
        this.isDelete = isDelete;
    }
    public Cart(User khachHang){
        this.khachHang = khachHang;
        isDelete = 0;
    }

    public int getMaGH() {
        return maGH;
    }

    public void setMaGH(int maGH) {
        this.maGH = maGH;
    }

    public User getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(User khachHang) {
        this.khachHang = khachHang;
    }

    public List<CartDetail> getChiTietGioHangs() {
        return chiTietGioHangs;
    }

    public void setChiTietGioHangs(List<CartDetail> chiTietGioHangs) {
        this.chiTietGioHangs = chiTietGioHangs;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
