/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapLon.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HopDongController {

    public static Connection conn = null;
    public static Statement state = null;
    public static String sql;
    private static final String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=BaiTapLon;user=sa;password=bachdeptrai123";

    public static List<BaiTapLon.Model.HopDongModel> LayNguonHopDong() {
        List<BaiTapLon.Model.HopDongModel> arrHopDong = new ArrayList<>();
        String sql = "SELECT * FROM HopDong WHERE trash != 0 ";

        try (
                Connection conn = DriverManager.getConnection(dbURL); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                BaiTapLon.Model.HopDongModel hopdong = mapResultSetToHopDongModel(rs);
                arrHopDong.add(hopdong);
            }
        } catch (SQLException ex) {
            Logger
                    .getLogger(HopDongController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return arrHopDong;
    }

    public static BaiTapLon.Model.HopDongModel getHopDongById(Long id) {
        String sql = "SELECT * FROM HopDong WHERE Id = ?";
        BaiTapLon.Model.HopDongModel hopdong = null;

        try (
                Connection conn = DriverManager.getConnection(dbURL); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    hopdong = mapResultSetToHopDongModel(rs);
                }
            }
        } catch (SQLException ex) {
            Logger
                    .getLogger(HopDongController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return hopdong;
    }

    private static BaiTapLon.Model.HopDongModel mapResultSetToHopDongModel(
            ResultSet rs
    ) throws SQLException {
        return new BaiTapLon.Model.HopDongModel(
                rs.getLong("Id"),
                rs.getLong("IdMaPhongTro"),
                rs.getLong("IdNguoiDung"),
                rs.getString("NgayBatDauThue"),
                rs.getString("NgayKetThucThue"),
                rs.getFloat("TienDatCoc"),
                rs.getFloat("GiaPhong"),
                rs.getFloat("GiaDien"),
                rs.getFloat("GiaNuoc"),
                rs.getFloat("GiaInternet"),
                rs.getFloat("GiaRac"),
                rs.getInt("Trash"),
                rs.getString("status"),
                rs.getString("NgayTao"),
                rs.getString("NguoiTao"),
                rs.getString("NgaySua"),
                rs.getString("NguoiSua")
        );
    }

    public static void ThemHopDong(BaiTapLon.Model.HopDongModel hopdong) {
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);

            String sql = "INSERT INTO HopDong (IdMaPhongTro, IdNguoiDung, NgayBatDauThue, NgayKetThucThue, TienDatCoc, GiaPhong, GiaDien, GiaNuoc, GiaInternet, GiaRac, NgayTao, NguoiTao, NgaySua, NguoiSua, Trash, Status) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setLong(1, hopdong.getIdMaPhongTro());
            state.setLong(2, hopdong.getIdNguoiDung());
            state.setString(3, hopdong.getNgayBatDauThue());
            state.setString(4, hopdong.getNgayKetThucThue());
            state.setFloat(5, hopdong.getTienDatCoc());
            state.setFloat(6, hopdong.getGiaPhong());
            state.setFloat(7, hopdong.getGiaDien());
            state.setFloat(8, hopdong.getGiaNuoc());
            state.setFloat(9, hopdong.getGiaInternet());
            state.setFloat(10, hopdong.getGiaRac());
            state.setString(11, hopdong.getNgayTao());
            state.setString(12, hopdong.getNguoiTao());
            state.setString(13, hopdong.getNgaySua()); // Set null for NgaySua
            state.setString(14, hopdong.getNguoiSua()); // Set null for NguoiSua
            state.setInt(15, hopdong.getTrash());
            state.setString(16, hopdong.getStatus());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void CapNhatNguoiDung(BaiTapLon.Model.HopDongModel hopdong, String macu) {
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);

            String sql = "UPDATE HopDong SET IdMaPhongTro = ?, IdNguoiDung = ?,NgayBatDauThue = ?, NgayKetThucThue = ?, TienDatCoc = ?, GiaPhong = ?, "
                    + "GiaDien = ?, GiaNuoc = ?, GiaInternet = ?, GiaRac = ?, NgaySua = ?, NguoiSua = ?, Trash = ?, Status = ? "
                    + "WHERE Id = ?";
            state = conn.prepareStatement(sql);
            state.setLong(1, hopdong.getIdMaPhongTro());
            state.setLong(2, hopdong.getIdNguoiDung());
            state.setString(3, hopdong.getNgayBatDauThue());
            state.setString(4, hopdong.getNgayKetThucThue());
            state.setFloat(5, hopdong.getTienDatCoc());
            state.setFloat(6, hopdong.getGiaPhong());
            state.setFloat(7, hopdong.getGiaDien());
            state.setFloat(8, hopdong.getGiaNuoc());
            state.setFloat(9, hopdong.getGiaInternet());
            state.setFloat(10, hopdong.getGiaRac());
            state.setString(11, hopdong.getNgaySua()); // Set null for NgaySua
            state.setString(12, hopdong.getNguoiSua()); // Set null for NguoiSua
            state.setInt(13, hopdong.getTrash());
            state.setString(14, hopdong.getStatus());
            state.setString(15, macu);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
