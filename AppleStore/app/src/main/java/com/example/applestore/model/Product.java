package com.example.applestore.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;

public class Product implements Serializable {
    @SerializedName("MaSP")
    int MaSP;
    @SerializedName("danhMuc")
    private Category danhMuc;
    @SerializedName("tenSP")
    String TenSP;
    @SerializedName("MoTa")
    String MoTa;
    @SerializedName("GiaGoc")
    int GiaGoc;
    @SerializedName("GiaBanThuong")
    int GiaBanThuong;
    @SerializedName("GiaKhuyenMai")
    int GiaKhuyenMai;
    @SerializedName("SoLuong")
    int SoLuong;
    @SerializedName("Anh")
    String Anh;
    @SerializedName("MoTaNgan")
    String MoTaNgan;
    @SerializedName("isDeteted")
    int isDeteted;
    @SerializedName("ListAnhSanPham")
    private List<ProductPicture> ListAnhSanPham;
    @SerializedName("ListCTDH")
    private  List<OrderDetail> ListCTDH;

    public Product() {
    }

    public Product(int maSP, Category danhMuc, String tenSP, String moTa, int giaGoc, int giaBanThuong, int giaKhuyenMai, int soLuong, String anh, String moTaNgan, int isDeteted, List<ProductPicture> listAnhSanPham, List<OrderDetail> listCTDH) {
        MaSP = maSP;
        this.danhMuc = danhMuc;
        TenSP = tenSP;
        MoTa = moTa;
        GiaGoc = giaGoc;
        GiaBanThuong = giaBanThuong;
        GiaKhuyenMai = giaKhuyenMai;
        SoLuong = soLuong;
        Anh = anh;
        MoTaNgan = moTaNgan;
        this.isDeteted = isDeteted;
        ListAnhSanPham = listAnhSanPham;
        ListCTDH = listCTDH;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public Category getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(Category danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getGiaGoc() {
        return GiaGoc;
    }

    public void setGiaGoc(int giaGoc) {
        GiaGoc = giaGoc;
    }

    public int getGiaBanThuong() {
        return GiaBanThuong;
    }

    public void setGiaBanThuong(int giaBanThuong) {
        GiaBanThuong = giaBanThuong;
    }

    public int getGiaKhuyenMai() {
        return GiaKhuyenMai;
    }

    public void setGiaKhuyenMai(int giaKhuyenMai) {
        GiaKhuyenMai = giaKhuyenMai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public String getMoTaNgan() {
        return MoTaNgan;
    }

    public void setMoTaNgan(String moTaNgan) {
        MoTaNgan = moTaNgan;
    }

    public int getIsDeteted() {
        return isDeteted;
    }

    public void setIsDeteted(int isDeteted) {
        this.isDeteted = isDeteted;
    }

    public List<ProductPicture> getListAnhSanPham() {
        return ListAnhSanPham;
    }

    public void setListAnhSanPham(List<ProductPicture> listAnhSanPham) {
        ListAnhSanPham = listAnhSanPham;
    }

    public List<OrderDetail> getListCTDH() {
        return ListCTDH;
    }

    public void setListCTDH(List<OrderDetail> listCTDH) {
        ListCTDH = listCTDH;
    }
}
