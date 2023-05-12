package com.example.applestore.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CartDetail implements Serializable {
    @SerializedName("maCTGH")
    int maCTGH;
    @SerializedName("gioHang")
    private Cart gioHang;
    @SerializedName("maSP")
    int maSP;
    @SerializedName("soLuong")
    int soLuong;
    @SerializedName("idDelete")
    int idDelete;

    public CartDetail() {
    }

    public CartDetail(int maCTGH, Cart gioHang, int maSP, int soLuong, int idDelete) {
        this.maCTGH = maCTGH;
        this.gioHang = gioHang;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.idDelete = idDelete;
    }

    public int getMaCTGH() {
        return maCTGH;
    }

    public void setMaCTGH(int maCTGH) {
        this.maCTGH = maCTGH;
    }

    public Cart getGioHang() {
        return gioHang;
    }

    public void setGioHang(Cart gioHang) {
        this.gioHang = gioHang;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(int idDelete) {
        this.idDelete = idDelete;
    }
}
