package com.example.applestore.model;

public class CartDetail {
    private int MaCTGH;
    private int MaGH;
    private int MaSP;
    private int SoLuong;
    private int IsDelete;

    public CartDetail() {
    }

    public CartDetail(int maCTGH, int maGH, int maSP, int soLuong, int isDelete) {
        MaCTGH = maCTGH;
        MaGH = maGH;
        MaSP = maSP;
        SoLuong = soLuong;
        IsDelete = isDelete;
    }

    public int getMaCTGH() {
        return MaCTGH;
    }

    public void setMaCTGH(int maCTGH) {
        MaCTGH = maCTGH;
    }

    public int getMaGH() {
        return MaGH;
    }

    public void setMaGH(int maGH) {
        MaGH = maGH;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(int isDelete) {
        IsDelete = isDelete;
    }
}
