/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapLon.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class LoaiPhongController {

    public static Connection conn = null;
    public static Statement state = null;
    public static String sql;
    private static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=BaiTapLon;user=sa;password=bachdeptrai123";
    private static List<BaiTapLon.Model.LoaiPhongModel> arrLoaiPhong = new ArrayList<>();
    
    public static List<BaiTapLon.Model.LoaiPhongModel> LayNguonLoaiPhong() {
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Select * From LoaiPhong Order by TenLoaiPhong";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                BaiTapLon.Model.LoaiPhongModel khuvuc = new BaiTapLon.Model.LoaiPhongModel();
                khuvuc.setId(rs.getInt("Id"));
                khuvuc.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
                arrLoaiPhong.add(khuvuc);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiPhongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiPhongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return arrLoaiPhong;
    }
    
    public static void ThemKhuVuc(BaiTapLon.Model.LoaiPhongModel loaiphong) {
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);

            String sql = "INSERT INTO KhuVuc (TenLoaiPhong) "
                    + "VALUES (?)";
            state = conn.prepareStatement(sql);
            state.setString(1, loaiphong.getTenLoaiPhong());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiPhongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiPhongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void CapNhatKhuVuc(BaiTapLon.Model.LoaiPhongModel loaiphong, String macu) {
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);

            String sql = "UPDATE LoaiPhong SET TenLoaiPhong = ? WHERE Id = ?;";
            state = conn.prepareStatement(sql);
            state.setString(1, loaiphong.getTenLoaiPhong());
            state.setString(2, macu);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiPhongController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiPhongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoaiPhongController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
