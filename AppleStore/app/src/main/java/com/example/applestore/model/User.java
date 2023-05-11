package com.example.applestore.model;

public class User {
    private int MaKH;
    private String TenKH;
    private String TenTK;
    private String Email;
    private String Phone;
    private String DiaChi;
    private String MK;
    private int IsUser;
    private int IsAdmin;

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String tenTK) {
        TenTK = tenTK;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public int getIsUser() {
        return IsUser;
    }

    public void setIsUser(int isUser) {
        IsUser = isUser;
    }

    public int getIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        IsAdmin = isAdmin;
    }

    public User(int maKH, String tenKH, String tenTK, String email, String phone, String diaChi, String MK, int isUser, int isAdmin) {
        MaKH = maKH;
        TenKH = tenKH;
        TenTK = tenTK;
        Email = email;
        Phone = phone;
        DiaChi = diaChi;
        this.MK = MK;
        IsUser = isUser;
        IsAdmin = isAdmin;
    }

    public User() {
    }
}
