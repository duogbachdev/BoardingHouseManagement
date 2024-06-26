/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BaiTapLon.Views.ChuTro;

import BaiTapLon.Controllers.KhuVucController;
import BaiTapLon.Controllers.LoaiPhongController;
import BaiTapLon.Controllers.NguoiDungController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ADMIN
 */
public class frmKhuVuLoaiPhong extends javax.swing.JFrame {

    DefaultTableModel modelKV, modelLP;
    private static List<BaiTapLon.Model.KhuVucModel> arrKhuVuc = new ArrayList<>();
    private static List<BaiTapLon.Model.LoaiPhongModel> arrLoaiPhong = new ArrayList<>();
    private String macu, timKiem;
    private boolean ktThem;

    /**
     * Creates new form frmKhuVuLoaiPhong
     */
    public frmKhuVuLoaiPhong() {
        initComponents();
        initKhuVuc();
        initLoaiPhong();
        LayNguonKV();
        LayNguonLP();
        XoaTrangKV();
        XoaTrangLP();
        KhoaMoKV(false);
        KhoaMoLP(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenKhuVuc = new javax.swing.JTextField();
        txtTang = new javax.swing.JTextField();
        txtDay = new javax.swing.JTextField();
        lblMaKhuVuc = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnKhongLuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuVuc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenLoaiPhong = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiPhong = new javax.swing.JTable();
        btnThem2 = new javax.swing.JButton();
        btnXoa2 = new javax.swing.JButton();
        btnSua2 = new javax.swing.JButton();
        btnReset2 = new javax.swing.JButton();
        btnLuu2 = new javax.swing.JButton();
        btnKhongLuu2 = new javax.swing.JButton();
        lblMaPhong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Khu vực và Loại Phòng");

        jPanel1.setBackground(new java.awt.Color(40, 46, 62));

        jPanel2.setBackground(new java.awt.Color(46, 56, 86));

        jLabel1.setBackground(new java.awt.Color(255, 205, 31));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 205, 31));
        jLabel1.setText("KHU VỰC");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã khu vực");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên khu vực");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tầng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dãy");

        lblMaKhuVuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaKhuVuc.setForeground(new java.awt.Color(255, 205, 31));
        lblMaKhuVuc.setText("XX");

        btnThem.setBackground(new java.awt.Color(255, 205, 31));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/add.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 205, 31));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/edit.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 205, 31));
        btnXoa.setForeground(new java.awt.Color(255, 205, 31));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/litter.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 205, 31));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/return.png"))); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(255, 205, 31));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/diskette (1).png"))); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnKhongLuu.setBackground(new java.awt.Color(255, 205, 31));
        btnKhongLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/cancel (1).png"))); // NOI18N
        btnKhongLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongLuuActionPerformed(evt);
            }
        });

        tblKhuVuc.setBackground(new java.awt.Color(207, 243, 243));
        tblKhuVuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhuVuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuVucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuVuc);
        if (tblKhuVuc.getColumnModel().getColumnCount() > 0) {
            tblKhuVuc.getColumnModel().getColumn(0).setResizable(false);
            tblKhuVuc.getColumnModel().getColumn(1).setResizable(false);
            tblKhuVuc.getColumnModel().getColumn(2).setResizable(false);
            tblKhuVuc.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(40, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblMaKhuVuc)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDay)
                            .addComponent(txtTang)
                            .addComponent(txtTenKhuVuc))))
                .addGap(34, 34, 34))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnLuu)
                        .addGap(18, 18, 18)
                        .addComponent(btnKhongLuu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblMaKhuVuc))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnReset)
                    .addComponent(btnLuu)
                    .addComponent(btnKhongLuu))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(46, 56, 86));

        jLabel7.setBackground(new java.awt.Color(255, 205, 31));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 205, 31));
        jLabel7.setText("LOẠI PHÒNG");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mã phòng:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tên loại phòng");

        tblLoaiPhong.setBackground(new java.awt.Color(207, 243, 243));
        tblLoaiPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiPhong);

        btnThem2.setBackground(new java.awt.Color(255, 205, 31));
        btnThem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/add.png"))); // NOI18N
        btnThem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem2ActionPerformed(evt);
            }
        });

        btnXoa2.setBackground(new java.awt.Color(255, 205, 31));
        btnXoa2.setForeground(new java.awt.Color(255, 205, 31));
        btnXoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/litter.png"))); // NOI18N
        btnXoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa2ActionPerformed(evt);
            }
        });

        btnSua2.setBackground(new java.awt.Color(255, 205, 31));
        btnSua2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/edit.png"))); // NOI18N
        btnSua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua2ActionPerformed(evt);
            }
        });

        btnReset2.setBackground(new java.awt.Color(255, 205, 31));
        btnReset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/return.png"))); // NOI18N
        btnReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset2ActionPerformed(evt);
            }
        });

        btnLuu2.setBackground(new java.awt.Color(255, 205, 31));
        btnLuu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/diskette (1).png"))); // NOI18N
        btnLuu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuu2ActionPerformed(evt);
            }
        });

        btnKhongLuu2.setBackground(new java.awt.Color(255, 205, 31));
        btnKhongLuu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BaiTapLon/Icon/cancel (1).png"))); // NOI18N
        btnKhongLuu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongLuu2ActionPerformed(evt);
            }
        });

        lblMaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaPhong.setForeground(new java.awt.Color(255, 205, 31));
        lblMaPhong.setText("XX");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMaPhong)
                                    .addComponent(txtTenLoaiPhong)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThem2)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa2)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReset2)
                                .addGap(18, 18, 18)
                                .addComponent(btnLuu2)
                                .addGap(18, 18, 18)
                                .addComponent(btnKhongLuu2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel7)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblMaPhong))
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem2)
                    .addComponent(btnSua2)
                    .addComponent(btnXoa2)
                    .addComponent(btnReset2)
                    .addComponent(btnLuu2)
                    .addComponent(btnKhongLuu2))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void tblKhuVucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuVucMouseClicked
      // TODO add your handling code here:
      int index = tblKhuVuc.getSelectedRow();
      TableModel model = tblKhuVuc.getModel();
      String id = model.getValueAt(index, 0).toString();
      String tenKhuVuc = model.getValueAt(index, 1).toString();
      String tang = model.getValueAt(index, 2).toString();
      String dayNhaTro = model.getValueAt(index, 3).toString();
      lblMaKhuVuc.setText(id);
      txtTenKhuVuc.setText(tenKhuVuc);
      txtTang.setText(tang);
      txtDay.setText(dayNhaTro);
  }//GEN-LAST:event_tblKhuVucMouseClicked

  private void tblLoaiPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiPhongMouseClicked
      // TODO add your handling code here:
      int index = tblLoaiPhong.getSelectedRow();
      TableModel model = tblLoaiPhong.getModel();
      String id = model.getValueAt(index, 0).toString();
      String tenLoaiPhong = model.getValueAt(index, 1).toString();
      lblMaPhong.setText(id);
      txtTenLoaiPhong.setText(tenLoaiPhong);
  }//GEN-LAST:event_tblLoaiPhongMouseClicked

  private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
      // TODO add your handling code here:
      ktThem = true;
      macu = "";
      KhoaMoKV(true);
      XoaTrangKV();
      txtTenKhuVuc.requestFocus();
  }//GEN-LAST:event_btnThemActionPerformed

  private void btnThem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem2ActionPerformed
      // TODO add your handling code here:
      ktThem = true;
      macu = "";
      KhoaMoLP(true);
      XoaTrangLP();
      txtTenLoaiPhong.requestFocus();
  }//GEN-LAST:event_btnThem2ActionPerformed

  private void btnKhongLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongLuuActionPerformed
      // TODO add your handling code here:
      XoaTrangKV();
      KhoaMoKV(false);
  }//GEN-LAST:event_btnKhongLuuActionPerformed

  private void btnKhongLuu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongLuu2ActionPerformed
      // TODO add your handling code here:
      XoaTrangLP();
      KhoaMoLP(false);
  }//GEN-LAST:event_btnKhongLuu2ActionPerformed

  private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
      // TODO add your handling code here:
      String tenKhuVuc = txtTenKhuVuc.getText();
      int tang = Integer.parseInt(txtTang.getText());
      int day = Integer.parseInt(txtDay.getText());

      BaiTapLon.Model.KhuVucModel khuvuc = new BaiTapLon.Model.KhuVucModel(
              tenKhuVuc,
              tang,
              day
      );
      if (ktThem == true) {
          KhuVucController.ThemKhuVuc(khuvuc);
      } else {
          KhuVucController.CapNhatKhuVuc(khuvuc, macu);
      }
      LayNguonKV();
      KhoaMoKV(false);
  }//GEN-LAST:event_btnLuuActionPerformed

  private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
      // TODO add your handling code here:
      XoaTrangKV();
  }//GEN-LAST:event_btnResetActionPerformed

  private void btnReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset2ActionPerformed
      // TODO add your handling code here:
      XoaTrangLP();
  }//GEN-LAST:event_btnReset2ActionPerformed

  private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
      // TODO add your handling code here:
      if (txtTenKhuVuc.getText().length() <= 0) {
          JOptionPane.showConfirmDialog(
                  null,
                  "Bạn chưa chọn khu vực nào",
                  "Thông Báo",
                  JOptionPane.DEFAULT_OPTION,
                  JOptionPane.ERROR_MESSAGE
          );
          return;
      }
      ktThem = false;
      macu = lblMaKhuVuc.getText();
      KhoaMoKV(true);
      txtTenKhuVuc.requestFocus();
  }//GEN-LAST:event_btnSuaActionPerformed

  private void btnSua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua2ActionPerformed
      // TODO add your handling code here:
      if (txtTenLoaiPhong.getText().length() <= 0) {
          JOptionPane.showConfirmDialog(
                  null,
                  "Bạn chưa chọn loại phòng nào",
                  "Thông Báo",
                  JOptionPane.DEFAULT_OPTION,
                  JOptionPane.ERROR_MESSAGE
          );
          return;
      }
      ktThem = false;
      macu = lblMaPhong.getText();
      KhoaMoLP(true);
      txtTenLoaiPhong.requestFocus();
  }//GEN-LAST:event_btnSua2ActionPerformed

  private void btnLuu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuu2ActionPerformed
      // TODO add your handling code here:
      String tenLoaiPhong = txtTenLoaiPhong.getText();

      BaiTapLon.Model.LoaiPhongModel loaiphong = new BaiTapLon.Model.LoaiPhongModel(
              tenLoaiPhong
      );
      if (ktThem == true) {
          LoaiPhongController.ThemKhuVuc(loaiphong);
      } else {
          LoaiPhongController.CapNhatKhuVuc(loaiphong, macu);
      }
      LayNguonLP();
      KhoaMoLP(false);
  }//GEN-LAST:event_btnLuu2ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (txtTenKhuVuc.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(
                    null,
                    "Bạn chưa chọn khu vực nào",
                    "Thông Báo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        macu = lblMaKhuVuc.getText();
        for (int i = 0; i < arrKhuVuc.size(); i++) {
            if (Integer.toString(arrKhuVuc.get(i).getId()).equals(macu)) {
                int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khu vực không ?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (kq == JOptionPane.YES_OPTION) {
                    KhuVucController.XoaKhuVuc(macu);
                    XoaTrangKV();
                    LayNguonKV();
                }
                return;
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa2ActionPerformed
        // TODO add your handling code here:
        if (txtTenLoaiPhong.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(
                    null,
                    "Bạn chưa chọn loại phòng nào",
                    "Thông Báo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        macu = lblMaPhong.getText();
        for (int i = 0; i < arrLoaiPhong.size(); i++) {
            if (Integer.toString(arrLoaiPhong.get(i).getId()).equals(macu)) {
                int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khu vực không ?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (kq == JOptionPane.YES_OPTION) {
                    LoaiPhongController.XoaLoaiPhong(macu);
                    XoaTrangLP();
                    LayNguonLP();
                }
                return;
            }
        }
    }//GEN-LAST:event_btnXoa2ActionPerformed

    public void initKhuVuc() {
        modelKV = (DefaultTableModel) tblKhuVuc.getModel();
        String[] columns = {"Id", "Tên khu vực", "Tầng", "Dãy nhà trọ"};
        modelKV.setColumnIdentifiers(columns);
    }

    public void initLoaiPhong() {
        modelLP = (DefaultTableModel) tblLoaiPhong.getModel();
        String[] columns = {"Id", "Tên loại phòng"};
        modelLP.setColumnIdentifiers(columns);
    }

    public void LayNguonKV() {
        arrKhuVuc = KhuVucController.LayNguonKhuVuc();
        modelKV.setRowCount(0);
        arrKhuVuc.forEach((KhuVuc) -> {
            modelKV.addRow(new Object[]{
                KhuVuc.getId(),
                KhuVuc.getTenKhuVuc(),
                KhuVuc.getTang(),
                KhuVuc.getDay(),});
        });
    }

    public void LayNguonLP() {
        arrLoaiPhong = LoaiPhongController.LayNguonLoaiPhong();
        //        System.out.println("data" + arrNguoiDung);
        modelLP.setRowCount(0);
        arrLoaiPhong.forEach(LoaiPhong -> {
            modelLP.addRow(
                    new Object[]{LoaiPhong.getId(), LoaiPhong.getTenLoaiPhong()}
            );
        });
    }

    public void XoaTrangKV() {
        lblMaKhuVuc.setText("XX");
        txtTenKhuVuc.setText("");
        txtDay.setText("");
        txtTang.setText("");
    }

    public void XoaTrangLP() {
        lblMaPhong.setText("XX");
        txtTenLoaiPhong.setText("");
    }

    public void KhoaMoKV(boolean b) {
        txtTenKhuVuc.setEditable(b);
        txtDay.setEditable(b);
        txtTang.setEditable(b);
        txtTenLoaiPhong.setEditable(b);

        tblKhuVuc.setEnabled(!b);
        btnThem.setEnabled(!b);
        btnXoa.setEnabled(!b);
        btnSua.setEnabled(!b);
        btnReset.setEnabled(!b);

        btnLuu.setEnabled(b);
        btnKhongLuu.setEnabled(b);
    }

    public void KhoaMoLP(boolean b) {
        txtTenLoaiPhong.setEditable(b);

        tblLoaiPhong.setEnabled(!b);
        btnThem2.setEnabled(!b);
        btnXoa2.setEnabled(!b);
        btnSua2.setEnabled(!b);
        btnReset2.setEnabled(!b);

        btnLuu2.setEnabled(b);
        btnKhongLuu2.setEnabled(b);
    }

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
            java.util.logging.Logger
                    .getLogger(frmKhuVuLoaiPhong.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger
                    .getLogger(frmKhuVuLoaiPhong.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger
                    .getLogger(frmKhuVuLoaiPhong.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger
                    .getLogger(frmKhuVuLoaiPhong.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(
                new Runnable() {
            public void run() {
                new frmKhuVuLoaiPhong().setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKhongLuu;
    private javax.swing.JButton btnKhongLuu2;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnLuu2;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset2;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua2;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem2;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMaKhuVuc;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JTable tblKhuVuc;
    private javax.swing.JTable tblLoaiPhong;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtTang;
    private javax.swing.JTextField txtTenKhuVuc;
    private javax.swing.JTextField txtTenLoaiPhong;
    // End of variables declaration//GEN-END:variables
}
