package com.example.applestore.model;

import java.util.Date;

public class Order {
    private  int MaDH;
    private int TongTien;
    private String DiaChi;
    private Date NgayDatHang;
    private int MaKH;
    private int MaTrangThai;

    public Order() {
    }

    public Order(int maDH, int tongTien, String diaChi, Date ngayDatHang, int maKH, int maTrangThai) {
        MaDH = maDH;
        TongTien = tongTien;
        DiaChi = diaChi;
        NgayDatHang = ngayDatHang;
        MaKH = maKH;
        MaTrangThai = maTrangThai;
    }

    public int getMaDH() {
        return MaDH;
    }

    public void setMaDH(int maDH) {
        MaDH = maDH;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien = tongTien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public Date getNgayDatHang() {
        return NgayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        NgayDatHang = ngayDatHang;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public int getMaTrangThai() {
        return MaTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        MaTrangThai = maTrangThai;
    }
}
