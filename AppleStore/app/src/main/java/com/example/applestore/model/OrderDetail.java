package com.example.applestore.model;

public class OrderDetail {
    private int MaCTDH;
    private int MaSP;
    private int MaDH;
    private int SoLuong;
    private int TongTien;

    public int getMaCTDH() {
        return MaCTDH;
    }

    public void setMaCTDH(int maCTDH) {
        MaCTDH = maCTDH;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public int getMaDH() {
        return MaDH;
    }

    public void setMaDH(int maDH) {
        MaDH = maDH;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien = tongTien;
    }

    public OrderDetail() {
    }

    public OrderDetail(int maCTDH, int maSP, int maDH, int soLuong, int tongTien) {
        MaCTDH = maCTDH;
        MaSP = maSP;
        MaDH = maDH;
        SoLuong = soLuong;
        TongTien = tongTien;
    }
}
