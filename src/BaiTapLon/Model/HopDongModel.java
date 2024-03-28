/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapLon.Model;

/**
 *
 * @author ADMIN
 */
public class HopDongModel {

    private long id;
    private long idMaPhongTro;
    private long idNguoiDung;
    private String ngayBatDauThue;
    private String ngayKetThucThue;
    private float tienDatCoc;
    private float giaPhong;
    private float giaDien;
    private float giaNuoc;
    private float giaInternet;
    private float giaRac;
    private int trash;
    private String status;
    private String ngayTao;
    private String nguoiTao;
    private String ngaySua;
    private String nguoiSua;

    public HopDongModel() {
    }

    public HopDongModel(long id, long idMaPhongTro, long idNguoiDung, String ngayBatDauThue, String ngayKetThucThue, float tienDatCoc, float giaPhong, float giaDien, float giaNuoc, float giaInternet, float giaRac, int trash, String status, String ngayTao, String nguoiTao, String ngaySua, String nguoiSua) {
        this.id = id;
        this.idMaPhongTro = idMaPhongTro;
        this.idNguoiDung = idNguoiDung;
        this.ngayBatDauThue = ngayBatDauThue;
        this.ngayKetThucThue = ngayKetThucThue;
        this.tienDatCoc = tienDatCoc;
        this.giaPhong = giaPhong;
        this.giaDien = giaDien;
        this.giaNuoc = giaNuoc;
        this.giaInternet = giaInternet;
        this.giaRac = giaRac;
        this.trash = trash;
        this.status = status;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.ngaySua = ngaySua;
        this.nguoiSua = nguoiSua;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdMaPhongTro() {
        return idMaPhongTro;
    }

    public void setIdMaPhongTro(long idMaPhongTro) {
        this.idMaPhongTro = idMaPhongTro;
    }

    public long getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(long idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public String getNgayBatDauThue() {
        return ngayBatDauThue;
    }

    public void setNgayBatDauThue(String ngayBatDauThue) {
        this.ngayBatDauThue = ngayBatDauThue;
    }

    public String getNgayKetThucThue() {
        return ngayKetThucThue;
    }

    public void setNgayKetThucThue(String ngayKetThucThue) {
        this.ngayKetThucThue = ngayKetThucThue;
    }

    public float getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(float tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }

    public float getGiaDien() {
        return giaDien;
    }

    public void setGiaDien(float giaDien) {
        this.giaDien = giaDien;
    }

    public float getGiaNuoc() {
        return giaNuoc;
    }

    public void setGiaNuoc(float giaNuoc) {
        this.giaNuoc = giaNuoc;
    }

    public float getGiaInternet() {
        return giaInternet;
    }

    public void setGiaInternet(float giaInternet) {
        this.giaInternet = giaInternet;
    }

    public float getGiaRac() {
        return giaRac;
    }

    public void setGiaRac(float giaRac) {
        this.giaRac = giaRac;
    }

    public int getTrash() {
        return trash;
    }

    public void setTrash(int trash) {
        this.trash = trash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(String nguoiSua) {
        this.nguoiSua = nguoiSua;
    }
    
    
}
