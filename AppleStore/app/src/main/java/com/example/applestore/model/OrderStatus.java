package com.example.applestore.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderStatus implements Serializable {

    @SerializedName("maTrangThai")
    int maTrangThai;
    @SerializedName("tenTrangThai")
    String tenTrangThai;
    @SerializedName("listDonHang")
    private List<Order> listDonHang;


    public OrderStatus() {
    }

    public OrderStatus(int maTrangThai, String tenTrangThai, List<Order> listDonHang) {
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = tenTrangThai;
        this.listDonHang = listDonHang;
    }

    public int getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    public List<Order> getListDonHang() {
        return listDonHang;
    }

    public void setListDonHang(List<Order> listDonHang) {
        this.listDonHang = listDonHang;
    }
}
