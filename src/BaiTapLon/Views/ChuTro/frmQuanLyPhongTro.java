/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BaiTapLon.Views.ChuTro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.table.TableModel;
/**
 *
 * @author ADMIN
 */
public class frmQuanLyPhongTro extends javax.swing.JFrame {
String url = "jdbc:sqlserver://localhost:1433;databaseName=BaiTapLon;encrypt=true;trustServerCertificate=true;";
    String user = "sa";
    String pass = "bachdeptrai123";
    Connection con = null;
    int selectedStatus = -1; // Mặc định là hiển thị tất cả
    /**
     * Creates new form frmQuanLyPhongTro
     */
    private ButtonGroup trangThaiGroup;
    public frmQuanLyPhongTro() {
        initComponents();
    trangThaiGroup = new ButtonGroup();
    trangThaiGroup.add(jbtdathue);
    trangThaiGroup.add(jbtchuathue);
    trangThaiGroup.add(jbtchoduyet);
   
    // Thêm sự kiện focus vào ô text khi khởi tạo giao diện người dùng
    txttimkiem.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
        // Xóa Prompt Text khi ô text được focus
        if (txttimkiem.getText().equals("Nhập ID phòng để tìm kiếm...")) {
            txttimkiem.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (txttimkiem.getText().isEmpty()) {
            // Hiển thị lại Prompt Text khi ô text mất focus và trống
            txttimkiem.setText("Nhập ID phòng để tìm kiếm...");
        }
    }
});
  setComboBoxListener();
    }
   private void setComboBoxListener() {
        cbbhienthidulieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi người dùng chọn một mục trong combobox
                cbbhienthidulieuActionPerformed(e);
            }
        });
    }
    

    public void showtable(int selectedStatus) throws ClassNotFoundException, SQLException {
        tblquanlyphongtro.removeAll(); // Xóa tất cả các dòng trong bảng

        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, pass);

            // Câu truy vấn SQL để lấy dữ liệu từ cơ sở dữ liệu với điều kiện lọc theo selectedStatus
            String sql = "SELECT * FROM PhongTro";

            // Nếu selectedStatus không phải là -1 (tức là không phải hiển thị tất cả), thêm điều kiện vào câu truy vấn
            if (selectedStatus != -1) {
                sql += " WHERE Status = ?";
            }

            PreparedStatement pstmt = con.prepareStatement(sql);

            // Nếu selectedStatus không phải là -1, thiết lập tham số cho câu truy vấn
            if (selectedStatus != -1) {
                pstmt.setInt(1, selectedStatus);
            }

            ResultSet rs = pstmt.executeQuery();

            // Tạo một DefaultTableModel với các cột tương ứng
            String[] rowhead = {"ID", "IdMaLoaiPhong", "IdNguoiDung", "IdKhuVuc", "TenPhong", "DienTich", "GiaPhong", "DiaChi", "MoTa", "Status"};
            DefaultTableModel model = new DefaultTableModel(rowhead, 0);

            // Đọc dữ liệu từ ResultSet và thêm vào model
            while (rs.next()) {
                Object[] row = {
                    rs.getString("ID"),
                    rs.getString("IdMaLoaiPhong"),
                    rs.getString("IdNguoiDung"),
                    rs.getString("IdKhuVuc"),
                    rs.getString("TenPhong"),
                    rs.getString("DienTich"),
                    rs.getString("GiaPhong"),
                    rs.getString("DiaChi"),
                    rs.getString("MoTa"),
                    rs.getString("Status")
                };
                model.addRow(row);
            }

            // Đặt model cho bảng tblquanlyphongtro
            tblquanlyphongtro.setModel(model);

            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

private void resetFields() {
    txtmaloaiphong.setEnabled(true);
    txtmanguoidung.setEnabled(true);
    txtmakhuvuc.setEnabled(true);
    
    
    lblidtro.setText("");
    txtmaloaiphong.setText("");
    txtmanguoidung.setText("");
    txtmakhuvuc.setText("");
    txttenphong.setText("");
    txtdientich.setText("");
    txtgiaphong.setText("");
    txtdiachi.setText("");
    txtmota.setText("");
    jbtdathue.setEnabled(true);
    jbtchuathue.setEnabled(true);
    jbtchoduyet.setEnabled(true);
    
}
private void searchByID(String id) {
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, user, pass);
        
        String sql = "SELECT * FROM PhongTro WHERE IdMaLoaiPhong = ? AND status = 1 AND trash != 0";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id); // Thiết lập tham số cho ID cần tìm kiếm
        
        ResultSet rs = pstmt.executeQuery();
        
        // Xóa dữ liệu cũ trong bảng trước khi hiển thị kết quả mới
        DefaultTableModel model = (DefaultTableModel) tblquanlyphongtro.getModel();
        model.setRowCount(0);
        
        // Hiển thị kết quả tìm kiếm trên bảng
        while (rs.next()) {
            Vector row = new Vector();
            row.add(rs.getString("ID"));
            row.add(rs.getString("IdMaLoaiPhong"));
            row.add(rs.getString("IdNguoiDung"));
            row.add(rs.getString("IdKhuVuc"));
            row.add(rs.getString("TenPhong"));
            row.add(rs.getString("DienTich"));
            row.add(rs.getString("GiaPhong"));
            row.add(rs.getString("DiaChi"));
            row.add(rs.getString("MoTa"));
            row.add(rs.getString("Status"));
            model.addRow(row);
        }
        
        pstmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi hệ thống: " + e.getMessage());
    }
} 
/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtmaloaiphong = new javax.swing.JTextField();
        txtmanguoidung = new javax.swing.JTextField();
        txtdientich = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        txtmakhuvuc = new javax.swing.JTextField();
        txttenphong = new javax.swing.JTextField();
        txtgiaphong = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jbtdathue = new javax.swing.JRadioButton();
        jbtchuathue = new javax.swing.JRadioButton();
        jbtchoduyet = new javax.swing.JRadioButton();
        btntaohopdong = new javax.swing.JButton();
        lblidtro = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnthungrac = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnxoavaothungrac = new javax.swing.JButton();
        cbbhienthidulieu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblquanlyphongtro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(40, 46, 62));
        jPanel1.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(46, 56, 86));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 205, 31), 2), "Tìm Kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 205, 31))); // NOI18N

        txttimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txttimkiem.setForeground(new java.awt.Color(40, 46, 62));
        txttimkiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttimkiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttimkiemFocusLost(evt);
            }
        });
        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });

        btntimkiem.setBackground(new java.awt.Color(255, 205, 31));
        btntimkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntimkiem.setForeground(new java.awt.Color(40, 46, 62));
        btntimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/magnifier.png"))); // NOI18N
        btntimkiem.setText("Tìm Kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(207, 243, 243));

        jLabel1.setBackground(new java.awt.Color(40, 46, 62));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 46, 62));
        jLabel1.setText("QUẢN LÝ PHÒNG TRỌ ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 46, 62));
        jLabel2.setText("Mã loại phòng:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 46, 62));
        jLabel3.setText("Mã người dùng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(40, 46, 62));
        jLabel4.setText("Diện tích:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(40, 46, 62));
        jLabel5.setText("Địa chỉ:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(40, 46, 62));
        jLabel8.setText("Giá phòng:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(40, 46, 62));
        jLabel9.setText("Tên phòng:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(40, 46, 62));
        jLabel10.setText("Mã khu vực:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(40, 46, 62));
        jLabel11.setText("Mô tả:");

        txtmaloaiphong.setBackground(new java.awt.Color(153, 153, 153));

        txtmanguoidung.setBackground(new java.awt.Color(153, 153, 153));

        txtdientich.setBackground(new java.awt.Color(153, 153, 153));

        txtdiachi.setBackground(new java.awt.Color(153, 153, 153));

        txtmakhuvuc.setBackground(new java.awt.Color(153, 153, 153));

        txttenphong.setBackground(new java.awt.Color(153, 153, 153));

        txtgiaphong.setBackground(new java.awt.Color(153, 153, 153));

        txtmota.setBackground(new java.awt.Color(153, 153, 153));
        txtmota.setColumns(20);
        txtmota.setRows(5);
        jScrollPane2.setViewportView(txtmota);

        jLabel6.setText("Tình trạng:");

        jbtdathue.setText("Đã thuê");

        jbtchuathue.setText("Chưa thuê");

        jbtchoduyet.setText("chờ duyệt");

        btntaohopdong.setBackground(new java.awt.Color(204, 204, 204));
        btntaohopdong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntaohopdong.setText("Tạo hợp đồng");
        btntaohopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaohopdongActionPerformed(evt);
            }
        });

        lblidtro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblidtro.setForeground(new java.awt.Color(255, 255, 0));
        lblidtro.setText("XX");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("ID:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel7)
                        .addGap(29, 29, 29)
                        .addComponent(lblidtro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtmanguoidung)
                                        .addComponent(txtmaloaiphong, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                        .addComponent(txtdientich))
                                    .addGap(64, 64, 64)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtgiaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txttenphong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtmakhuvuc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtdiachi)
                                .addComponent(jScrollPane2))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jbtdathue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtchuathue, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtchoduyet, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btntaohopdong)))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblidtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(txtmaloaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmakhuvuc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttenphong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel9)
                        .addComponent(txtmanguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdientich, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtgiaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jbtdathue)
                    .addComponent(jbtchuathue)
                    .addComponent(jbtchoduyet)
                    .addComponent(btntaohopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel5.setBackground(new java.awt.Color(46, 56, 86));

        btnthem.setBackground(new java.awt.Color(255, 205, 31));
        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthem.setForeground(new java.awt.Color(40, 46, 62));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/add.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(255, 205, 31));
        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnsua.setForeground(new java.awt.Color(40, 46, 62));
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/edit.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnthungrac.setBackground(new java.awt.Color(255, 205, 31));
        btnthungrac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnthungrac.setForeground(new java.awt.Color(40, 46, 62));
        btnthungrac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/delete.png"))); // NOI18N
        btnthungrac.setText("Thùng rác");
        btnthungrac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthungracActionPerformed(evt);
            }
        });

        btnreset.setBackground(new java.awt.Color(255, 205, 31));
        btnreset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnreset.setForeground(new java.awt.Color(40, 46, 62));
        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/return.png"))); // NOI18N
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnxoavaothungrac.setBackground(new java.awt.Color(255, 205, 31));
        btnxoavaothungrac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnxoavaothungrac.setForeground(new java.awt.Color(40, 46, 62));
        btnxoavaothungrac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/litter.png"))); // NOI18N
        btnxoavaothungrac.setText("Xóa");
        btnxoavaothungrac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoavaothungracActionPerformed(evt);
            }
        });

        cbbhienthidulieu.setBackground(new java.awt.Color(255, 205, 31));
        cbbhienthidulieu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbbhienthidulieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã Thuê", "Chưa Thuê", "Chờ Duyệt" }));
        cbbhienthidulieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbhienthidulieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxoavaothungrac, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnthungrac, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbhienthidulieu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoavaothungrac, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthungrac, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnreset, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(cbbhienthidulieu))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        tblquanlyphongtro.setBackground(new java.awt.Color(207, 243, 243));
        tblquanlyphongtro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblquanlyphongtro.setForeground(new java.awt.Color(40, 46, 62));
        tblquanlyphongtro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID LP", "ID ND", "ID KV", "Tên Phòng", "Diện Tích", "Giá Phòng", "Địa Chỉ", "Mô Tả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblquanlyphongtro.setSelectionBackground(new java.awt.Color(46, 56, 86));
        tblquanlyphongtro.setSelectionForeground(new java.awt.Color(255, 205, 31));
        tblquanlyphongtro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblquanlyphongtroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblquanlyphongtro);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        try {
            showtable(selectedStatus);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formComponentShown

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked



    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
      try {
        String maloaiphong = txtmaloaiphong.getText();
        String manguoidung = txtmanguoidung.getText();          
        String makhuvuc = txtmakhuvuc.getText();
        String tenphong = txttenphong.getText();        
        String dientich = txtdientich.getText();
        String giaphong = txtgiaphong.getText();
        String diachi = txtdiachi.getText();
        String mota = txtmota.getText();

        
        // Kiểm tra xem một trong ba nút radio đã được chọn chưa
        if (trangThaiGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái cho phòng trước khi thêm.");
            return;
        }

        // Xác định trạng thái từ các nút radio
        String trangthaiStr;
        if (jbtdathue.isSelected()) {
            trangthaiStr = "1"; // Đã thuê
        } else if (jbtchuathue.isSelected()) {
            trangthaiStr = "0"; // Chưa thuê
        } else {
            trangthaiStr = "2"; // Chờ duyệt
        }

        // Chuyển đổi từ String sang int
        int trangthai = Integer.parseInt(trangthaiStr);

        if (maloaiphong.isEmpty() || manguoidung.isEmpty() || makhuvuc.isEmpty() || tenphong.isEmpty() || mota.isEmpty()
                || dientich.isEmpty() || giaphong.isEmpty() || diachi.isEmpty()) {               
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
            return;
        }

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, user, pass);

        String sql = "INSERT INTO PhongTro (IdMaLoaiPhong, IdNguoiDung, IdKhuVuc, TenPhong, DienTich, GiaPhong, DiaChi, MoTa, Status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, maloaiphong);
        pstmt.setString(2, manguoidung);
        pstmt.setString(3, makhuvuc);
        pstmt.setString(4, tenphong);
        pstmt.setString(5, dientich);
        pstmt.setString(6, giaphong);
        pstmt.setString(7, diachi);
        pstmt.setString(8, mota);
        pstmt.setInt(9, trangthai); // Đã chuyển sang int ở đây

        int rowsAffected = pstmt.executeUpdate();
        pstmt.close();
        con.close();

        if (rowsAffected > 0) {
            showtable(selectedStatus);
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi hệ thống: " + e.getMessage());
    }
    }//GEN-LAST:event_btnthemActionPerformed
private String getStringValue(Object value) {
    return value != null ? value.toString() : "";
}
    private void tblquanlyphongtroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblquanlyphongtroMouseClicked
      int index = tblquanlyphongtro.getSelectedRow();
    if (index != -1) {
        TableModel model = tblquanlyphongtro.getModel();
        
        String id = getStringValue(model.getValueAt(index, 0));
        String maloaiphong = getStringValue(model.getValueAt(index, 1));
        String manguoidung = getStringValue(model.getValueAt(index, 2));
        String makhuvuc = getStringValue(model.getValueAt(index, 3));
        String tenphong = getStringValue(model.getValueAt(index, 4));
        String dientich = getStringValue(model.getValueAt(index, 5));
        String giaphong = getStringValue(model.getValueAt(index, 6));
        String diachi = getStringValue(model.getValueAt(index, 7));
        String mota = getStringValue(model.getValueAt(index, 8));
        String status = getStringValue(model.getValueAt(index, 9)); // Lấy giá trị của cột Status

        lblidtro.setText(id);
        txtmaloaiphong.setEnabled(false);
        txtmanguoidung.setEnabled(false);
        txtmakhuvuc.setEnabled(false);
        txtmaloaiphong.setText(maloaiphong);
        txtmanguoidung.setText(manguoidung);
        txtmakhuvuc.setText(makhuvuc);
        txttenphong.setText(tenphong);
        txtdientich.setText(dientich);
        txtgiaphong.setText(giaphong);
        txtdiachi.setText(diachi);
        txtmota.setText(mota);
        if (status != null) {
            if (status.equals("1")) {
                jbtdathue.setSelected(true);
            } else if (status.equals("0")) {
                jbtchuathue.setSelected(true);
            } else {
                jbtchoduyet.setSelected(true);
            }
        }
    }
    }//GEN-LAST:event_tblquanlyphongtroMouseClicked

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        try {
            resetFields();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
     int index = tblquanlyphongtro.getSelectedRow();
    if (index == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để sửa.");
        return;
    }

    try {
        String maloaiphong = txtmaloaiphong.getText();
        String manguoidung = txtmanguoidung.getText();          
        String makhuvuc = txtmakhuvuc.getText();
        String tenphong = txttenphong.getText();        
        String dientich = txtdientich.getText();
        String giaphong = txtgiaphong.getText();
        String diachi = txtdiachi.getText();
        String mota = txtmota.getText();

        // Lấy trạng thái mới từ nút radio được chọn
        String trangthaiStr;
        if (jbtdathue.isSelected()) {
            trangthaiStr = "1"; // Đã thuê
        } else if (jbtchuathue.isSelected()) {
            trangthaiStr = "0"; // Chưa thuê
        } else {
            trangthaiStr = "2"; // Chờ duyệt
        }

        // Lấy ID của hàng được chọn trong bảng
        int id = Integer.parseInt(tblquanlyphongtro.getValueAt(index, 0).toString());

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, user, pass);

        String sql = "UPDATE PhongTro SET IdMaLoaiPhong = ?, IdNguoiDung = ?, IdKhuVuc = ?, TenPhong = ?, "
                + "DienTich = ?, GiaPhong = ?, DiaChi = ?, MoTa = ?, Status = ? WHERE ID = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, maloaiphong);
        pstmt.setString(2, manguoidung);
        pstmt.setString(3, makhuvuc);
        pstmt.setString(4, tenphong);
        pstmt.setString(5, dientich);
        pstmt.setString(6, giaphong);
        pstmt.setString(7, diachi);
        pstmt.setString(8, mota);
        pstmt.setString(9, trangthaiStr); // Trạng thái mới
        pstmt.setInt(10, id);
       
        int rowsAffected = pstmt.executeUpdate();
        pstmt.close();
        con.close();

        if (rowsAffected > 0) {
            showtable(selectedStatus);
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi hệ thống: " + e.getMessage());
    }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoavaothungracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoavaothungracActionPerformed
    int index = tblquanlyphongtro.getSelectedRow();
    if (index == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa.");
        return;
    }

    try {
        // Lấy ID của hàng được chọn trong bảng
        int id = Integer.parseInt(tblquanlyphongtro.getValueAt(index, 0).toString());

        // Xác nhận việc xóa từ người dùng
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa bản ghi này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }

        // Cập nhật trường trash của bản ghi từ 1 thành 0 để đẩy vào thùng rác
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(url, user, pass);

        String sql = "UPDATE PhongTro SET trash = ? WHERE Id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, 0);
        pstmt.setInt(2, id);
       
        int rowsAffected = pstmt.executeUpdate();
        pstmt.close();
        con.close();

        if (rowsAffected > 0) {
            // Hiển thị lại dữ liệu trong bảng
            showtable(selectedStatus);
            JOptionPane.showMessageDialog(this, "Xóa và chuyển vào thùng rác thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa và chuyển vào thùng rác thất bại");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi hệ thống: " + e.getMessage());
    }
    }//GEN-LAST:event_btnxoavaothungracActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
           // Lấy giá trị nhập vào từ trường tìm kiếm
    String searchText = txttimkiem.getText();
    
    // Kiểm tra nếu trường tìm kiếm không rỗng
    if (!searchText.isEmpty()) {
        try {
            // Chuyển đổi giá trị từ trường tìm kiếm sang kiểu dữ liệu phù hợp nếu cần
            
            
            // Gọi phương thức tìm kiếm theo ID
            searchByID(searchText);
        } catch (NumberFormatException ex) {
            // Xử lý nếu không thể chuyển đổi thành công
            JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên là ID để tìm kiếm.");
        } catch (Exception e) {
            // Xử lý nếu có lỗi xảy ra
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm: " + e.getMessage());
        }
    } else {
        // Hiển thị thông báo nếu trường tìm kiếm rỗng
        JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên là ID để tìm kiếm.");
    }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void txttimkiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttimkiemFocusLost
        
    }//GEN-LAST:event_txttimkiemFocusLost

    private void btnthungracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthungracActionPerformed
        // TODO add your handling code here:
        frmThungRacPhongTro ThungRacPhongTro = new  frmThungRacPhongTro();
         // Hiển thị form ThungRacForm
         ThungRacPhongTro.setVisible(true);
    }//GEN-LAST:event_btnthungracActionPerformed

    private void btntaohopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaohopdongActionPerformed
        int index = tblquanlyphongtro.getSelectedRow();
        if (index != -1) {
        TableModel model = tblquanlyphongtro.getModel();
        String maphongtro = model.getValueAt(index, 0).toString();
        String manguoidung = model.getValueAt(index, 2).toString();
        String tennguoidung = ""; // Đây là dữ liệu bạn cần truy vấn từ cơ sở dữ liệu
        String sodienthoai = ""; // Đây cũng là dữ liệu bạn cần truy vấn từ cơ sở dữ liệu
        
        // Thực hiện truy vấn cơ sở dữ liệu để lấy thông tin tennguoidung và sodienthoai dựa vào idNguoiDung
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT HoTen, DienThoai FROM NguoiDung WHERE Id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, manguoidung);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                tennguoidung = rs.getString("HoTen");
                sodienthoai = rs.getString("DienThoai");
            }
            
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi truy vấn cơ sở dữ liệu: " + ex.getMessage());
            return;
        }
        
        // Hiển thị cửa sổ mới và chuyển dữ liệu sang
        frmThemHopDong themhopdong = new frmThemHopDong();
        themhopdong.setHopDongDetails(maphongtro, manguoidung, tennguoidung, sodienthoai);
        themhopdong.setVisible(true);
    }
    }//GEN-LAST:event_btntaohopdongActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void txttimkiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttimkiemFocusGained
      
    }//GEN-LAST:event_txttimkiemFocusGained

    private void cbbhienthidulieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbhienthidulieuActionPerformed
       // Lấy giá trị được chọn từ combobox
        String selectedOption = cbbhienthidulieu.getSelectedItem().toString();
        switch (selectedOption) {
            case "Tất cả":
                selectedStatus = -1; // Hiển thị tất cả các bản ghi
                break;
            case "Chưa Thuê":
                selectedStatus = 0; // Hiển thị các bản ghi với Status = 0
                break;
            case "Đã Thuê":
                selectedStatus = 1; // Hiển thị các bản ghi với Status = 1
                break;
            case "Chờ Duyệt":
                selectedStatus = 2; // Hiển thị các bản ghi với Status = 2
                break;
            default:
                break;
        }
        try {
            // Gọi phương thức showtable với giá trị selectedStatus tương ứng
            showtable(selectedStatus);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi hiển thị dữ liệu: " + ex.getMessage());
        }
    
    }//GEN-LAST:event_cbbhienthidulieuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyPhongTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyPhongTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyPhongTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQuanLyPhongTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQuanLyPhongTro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btntaohopdong;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthungrac;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoavaothungrac;
    private javax.swing.JComboBox<String> cbbhienthidulieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton jbtchoduyet;
    private javax.swing.JRadioButton jbtchuathue;
    private javax.swing.JRadioButton jbtdathue;
    private javax.swing.JLabel lblidtro;
    private javax.swing.JTable tblquanlyphongtro;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtdientich;
    private javax.swing.JTextField txtgiaphong;
    private javax.swing.JTextField txtmakhuvuc;
    private javax.swing.JTextField txtmaloaiphong;
    private javax.swing.JTextField txtmanguoidung;
    private javax.swing.JTextArea txtmota;
    private javax.swing.JTextField txttenphong;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
