package com.example.applestore.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;

public class Product implements Serializable {
    @SerializedName("maSP")
    int maSP;
    @SerializedName("danhMuc")
    private Category danhMuc;
    @SerializedName("tenSP")
    String tenSP;
    @SerializedName("moTa")
    String moTa;
    @SerializedName("giaGoc")
    int giaGoc;
    @SerializedName("giaBanThuong")
    int giaBanThuong;
    @SerializedName("giaKhuyenMai")
    int giaKhuyenMai;
    @SerializedName("soLuong")
    int soLuong;
    @SerializedName("anh")
    String anh;
    @SerializedName("moTaNgan")
    String moTaNgan;
    @SerializedName("isDeteted")
    int isDeteted;
    @SerializedName("listAnhSanPham")
    private List<ProductPicture> listAnhSanPham;
    @SerializedName("listCTDH")
    private  List<OrderDetail> listCTDH;

    public Product() {
    }

    public Product(int maSP, Category danhMuc, String tenSP, String moTa, int giaGoc, int giaBanThuong, int giaKhuyenMai, int soLuong, String anh, String moTaNgan, int isDeteted, List<ProductPicture> listAnhSanPham, List<OrderDetail> listCTDH) {
        this.maSP = maSP;
        this.danhMuc = danhMuc;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.giaGoc = giaGoc;
        this.giaBanThuong = giaBanThuong;
        this.giaKhuyenMai = giaKhuyenMai;
        this.soLuong = soLuong;
        this.anh = anh;
        this.moTaNgan = moTaNgan;
        this.isDeteted = isDeteted;
        this.listAnhSanPham = listAnhSanPham;
        this.listCTDH = listCTDH;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public Category getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(Category danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(int giaGoc) {
        this.giaGoc = giaGoc;
    }

    public int getGiaBanThuong() {
        return giaBanThuong;
    }

    public void setGiaBanThuong(int giaBanThuong) {
        this.giaBanThuong = giaBanThuong;
    }

    public int getGiaKhuyenMai() {
        return giaKhuyenMai;
    }

    public void setGiaKhuyenMai(int giaKhuyenMai) {
        this.giaKhuyenMai = giaKhuyenMai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMoTaNgan() {
        return moTaNgan;
    }

    public void setMoTaNgan(String moTaNgan) {
        this.moTaNgan = moTaNgan;
    }

    public int getIsDeteted() {
        return isDeteted;
    }

    public void setIsDeteted(int isDeteted) {
        this.isDeteted = isDeteted;
    }

    public List<ProductPicture> getListAnhSanPham() {
        return listAnhSanPham;
    }

    public void setListAnhSanPham(List<ProductPicture> listAnhSanPham) {
        this.listAnhSanPham = listAnhSanPham;
    }

    public List<OrderDetail> getListCTDH() {
        return listCTDH;
    }

    public void setListCTDH(List<OrderDetail> listCTDH) {
        this.listCTDH = listCTDH;
    }
}
