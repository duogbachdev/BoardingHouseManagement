package BaiTapLon.Controllers;

import BaiTapLon.Model.NguoiDungModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class NguoiDungController {

    public static Connection conn = null;
    public static Statement state = null;
    public static String sql;
    private static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=BaiTapLon;user=sa;password=bachdeptrai123";
    private static List<BaiTapLon.Model.NguoiDungModel> arrNguoiDung = new ArrayList<>();
    private static List<BaiTapLon.Model.NguoiDungModel> arr = new ArrayList<>();

    public static List<BaiTapLon.Model.NguoiDungModel> LayNguonNguoiDung() {
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Select * From NguoiDung  where trash !=0 Order by HoTen";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                BaiTapLon.Model.NguoiDungModel user = new BaiTapLon.Model.NguoiDungModel();
                user.setId(rs.getLong("Id"));
                user.setHoTen(rs.getString("HoTen"));
                user.setDienThoai(rs.getString("DienThoai"));
                user.setEmail(rs.getString("Email"));
                user.setDiaChi(rs.getString("DiaChi"));
                user.setMatKhau(rs.getString("MatKhau"));
                user.setRole(rs.getString("VaiTro"));
                arrNguoiDung.add(user);
            }
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
        return arrNguoiDung;
    }

    public static void ThemNguoiDung(BaiTapLon.Model.NguoiDungModel nguoidung) {
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);

            LocalDateTime currentTime = LocalDateTime.now();
            String sql = "INSERT INTO NguoiDung (HoTen, DienThoai, Email, DiaChi, MatKhau, VaiTro, NgayTao, NguoiTao) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, nguoidung.getHoTen());
            state.setString(2, nguoidung.getDienThoai());
            state.setString(3, nguoidung.getEmail());
            state.setString(4, nguoidung.getDiaChi());
            state.setString(5, nguoidung.getMatKhau());
            state.setString(6, nguoidung.getRole());
            state.setObject(7, currentTime);
            state.setString(8, nguoidung.getHoTen()); // Thay thế "your_nguoitao_value" bằng giá trị tương ứng
            // Thay thế "your_nguoisua_value" bằng giá trị tương ứng
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

    public static void XoaVaoThungRac(String manguoidung) {
        try {
            PreparedStatement state = null;
            conn = DriverManager.getConnection(dbURL);
            if (manguoidung == null) {
                throw new SQLException("Order rỗng");
            }
            String sql = "UPDATE NguoiDung SET trash = ? WHERE Id = ?";
            state = conn.prepareStatement(sql);
            state.setInt(1, 0);
            state.setString(2, manguoidung);
            state.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void CapNhatNguoiDung(BaiTapLon.Model.NguoiDungModel nguoidung, String macu) {
        PreparedStatement state = null;
        try {
            LocalDateTime currentTime = LocalDateTime.now();
            conn = DriverManager.getConnection(NguoiDungController.dbURL);

            String sql = "UPDATE NguoiDung SET HoTen = ?, DienThoai= ?, Email= ?, DiaChi= ?, VaiTro=?, NgaySua=?, NguoiSua=? WHERE Id = ?;";
            state = conn.prepareStatement(sql);
            state.setString(1, nguoidung.getHoTen());
            state.setString(2, nguoidung.getDienThoai());
            state.setString(3, nguoidung.getEmail());
            state.setString(4, nguoidung.getDiaChi());
            state.setString(5, nguoidung.getRole());
            state.setObject(6, currentTime);
            state.setString(7, nguoidung.getHoTen()); // Thay thế "your_nguoitao_value" bằng giá trị tương ứng
            // Thay thế "your_nguoisua_value" bằng giá trị tương ứng
            state.setString(8, macu);
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

    public static List<BaiTapLon.Model.NguoiDungModel> TimKiemNguoiDung(String timkiem) {
        List<BaiTapLon.Model.NguoiDungModel> arrNguoiDung = new ArrayList<>();
        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(dbURL);
            String sql = "SELECT * FROM NguoiDung WHERE Id LIKE ? OR DienThoai LIKE ? AND status = 1 AND trash != 0";
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + timkiem + "%");
            state.setString(2, "%" + timkiem + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                BaiTapLon.Model.NguoiDungModel user = new BaiTapLon.Model.NguoiDungModel();
                user.setId(rs.getLong("Id"));
                user.setHoTen(rs.getString("HoTen"));
                user.setDienThoai(rs.getString("DienThoai"));
                user.setEmail(rs.getString("Email"));
                user.setDiaChi(rs.getString("DiaChi"));
                user.setMatKhau(rs.getString("MatKhau"));
                user.setRole(rs.getString("VaiTro"));
                arrNguoiDung.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arrNguoiDung;
    }
    
    public static List<NguoiDungModel> LayNguonThungRacNguoiDung() {
        List<NguoiDungModel> arrThungRacNguoiDung = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "SELECT * FROM NguoiDung where trash = 0 ";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                BaiTapLon.Model.NguoiDungModel user = new BaiTapLon.Model.NguoiDungModel();
                user.setId(rs.getLong("Id"));
                user.setHoTen(rs.getString("HoTen"));
                user.setDienThoai(rs.getString("DienThoai"));
                user.setEmail(rs.getString("Email"));
                user.setDiaChi(rs.getString("DiaChi"));
                user.setMatKhau(rs.getString("MatKhau"));
                user.setRole(rs.getString("VaiTro"));
                arrNguoiDung.add(user);
            }
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
        return arrThungRacNguoiDung;
    }
}
