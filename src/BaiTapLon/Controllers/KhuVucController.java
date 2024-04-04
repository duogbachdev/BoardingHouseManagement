/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapLon.Controllers;

import static BaiTapLon.Controllers.NguoiDungController.conn;
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

/**
 *
 * @author ADMIN
 */
public class KhuVucController {

    public static Connection conn = null;
    public static Statement state = null;
    public static String sql;
    private static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=BaiTapLon;user=sa;password=bachdeptrai123";
    private static List<BaiTapLon.Model.KhuVucModel> arrKhuVuc = new ArrayList<>();

    public static List<BaiTapLon.Model.KhuVucModel> LayNguonKhuVuc() {
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Select * From KhuVuc";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                BaiTapLon.Model.KhuVucModel khuvuc = new BaiTapLon.Model.KhuVucModel();
                khuvuc.setId(rs.getInt("Id"));
                khuvuc.setTenKhuVuc(rs.getString("TenKhuVuc"));
                khuvuc.setTang(rs.getInt("Tang"));
                khuvuc.setDay(rs.getInt("DayNhaTro"));
                arrKhuVuc.add(khuvuc);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhuVucController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhuVucController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return arrKhuVuc;
    }

    public static void ThemKhuVuc(BaiTapLon.Model.KhuVucModel khuvuc) {
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);

            LocalDateTime currentTime = LocalDateTime.now();
            String sql = "INSERT INTO KhuVuc (TenKhuVuc, Tang, DayNhaTro) "
                    + "VALUES (?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, khuvuc.getTenKhuVuc());
            state.setInt(2, khuvuc.getTang());
            state.setInt(3, khuvuc.getDay());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhuVucController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhuVucController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhuVucController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void CapNhatKhuVuc(BaiTapLon.Model.KhuVucModel khuvuc, String macu) {
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(dbURL);

            String sql = "UPDATE KhuVuc SET TenKhuVuc = ?, Tang= ?, DayNhaTro= ? WHERE Id = ?;";
            state = conn.prepareStatement(sql);
            state.setString(1, khuvuc.getTenKhuVuc());
            state.setInt(2, khuvuc.getTang());
            state.setInt(3, khuvuc.getDay());
            state.setString(4, macu);
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
