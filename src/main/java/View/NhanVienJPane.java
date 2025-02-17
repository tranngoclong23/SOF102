/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.NhanVien;
import Service.NhanVienDAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class NhanVienJPane extends javax.swing.JPanel {

    ArrayList<NhanVien> nvList;
    DefaultTableModel tblModel;

    /**
     * Creates new form NhanVienJPane
     */
    public NhanVienJPane() {
        initComponents();
        initTable();
        loadDataToTable();
    }

    private List<NhanVien> layDanhSachNhanVien() {
        List<NhanVien> danhSachNV = new ArrayList<>();
        String url = "jdbc:sqlserver://localhost:1433;databaseName=SOF102_SD1808_SmileyBall";
        String user = "sa";
        String password = "123";

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement stmt = conn.prepareStatement("SELECT MaNV, TenNV, GioiTinh, SoDT, Email, Luong FROM NHANVIEN"); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maNV = rs.getString("MaNV");
                String tenNV = rs.getString("TenNV");
                String gioiTinh = rs.getString("GioiTinh");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                double luong = rs.getDouble("Luong");

                danhSachNV.add(new NhanVien(maNV, tenNV, gioiTinh, soDT, email, luong));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachNV;
    }

    private void initTable() {

        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã NV", "Tên NV", "Giới Tính", "Số ĐT", "Email", "Lương"});
        tblNvien.setModel(tblModel);
    }

    private void loadDataToTable() {
        tblModel.setRowCount(0);

        List<NhanVien> danhSachNV = layDanhSachNhanVien();
        for (NhanVien nv : danhSachNV) {
            tblModel.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getGioiTinh(),
                nv.getSoDT(),
                nv.getEmail(),
                nv.getLuong()
            });
        }
    }

    private void fillToTable(int rowIndex) {
        txtMa.setText(tblModel.getValueAt(rowIndex, 0).toString());
        txtTen.setText(tblModel.getValueAt(rowIndex, 1).toString());
        txtGioiTinh.setText(tblModel.getValueAt(rowIndex, 2).toString());
        txtSdt.setText(tblModel.getValueAt(rowIndex, 3).toString());
        txtEmail.setText(tblModel.getValueAt(rowIndex, 4).toString());
        txtLuong.setText(tblModel.getValueAt(rowIndex, 5).toString());
    }

    private boolean checkTrung(String MaNV) {
        List<NhanVien> danhSachNV = layDanhSachNhanVien();
        return danhSachNV.contains(MaNV);
    }

    private boolean checkNV() {
        double luong = Double.parseDouble(txtLuong.getText());
        if (luong <= 0) {
            JOptionPane.showMessageDialog(this, "Lương không hợp lệ! Vui lòng nhập lại!");
            return false;
        }
        return true;
    }

    private boolean checkLuu() {
        if (txtMa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống!");
            txtMa.requestFocus();
            return false;
        }
        if (checkTrung(txtMa.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ! Vui lòng nhập lại!");
            txtMa.requestFocus();
            return false;
        }

        if (txtTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống!");
            txtTen.requestFocus();
            return false;
        }

        if (txtGioiTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giới tính không được để trống!");
            txtGioiTinh.requestFocus();
            return false;
        }
        if (txtSdt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!");
            txtSdt.requestFocus();
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email không được để trống!");
            txtEmail.requestFocus();
            return false;
        }
        if (txtLuong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lương không được để trống!");
            txtLuong.requestFocus();
            return false;
        }
        return true;

    }

    private boolean checkCapNhat() {
        if (txtMa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống!");
            txtMa.requestFocus();
            return false;
        }
        if (checkTrung(txtMa.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ! Vui lòng nhập lại!");
            txtMa.requestFocus();
            return false;
        }

        if (txtTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống!");
            txtTen.requestFocus();
            return false;
        }

        if (txtGioiTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giới tính không được để trống!");
            txtGioiTinh.requestFocus();
            return false;
        }
        if (txtSdt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!");
            txtSdt.requestFocus();
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email không được để trống!");
            txtEmail.requestFocus();
            return false;
        }
        if (txtLuong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lương không được để trống!");
            txtLuong.requestFocus();
            return false;
        }
        return true;
    }

    public boolean checkXoa() {
        if (txtMa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống!");
            txtMa.requestFocus();
            return false;
        }
        return true;
    }

    public boolean checkTimKiem() {
        if (txtTImKiem.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điền mã nhân viên cần tìm kiếm!");
            txtTImKiem.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTImKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNvien = new javax.swing.JTable();

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setText("Tìm kiếm");

        jLabel12.setText("Mã nhân viên");

        jLabel13.setText("Giới tính");

        jLabel14.setText("Email");

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel16.setText("Tên nhân viên");

        jLabel17.setText("Số điện thoại");

        jLabel18.setText("Lương");

        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        tblNvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblNvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNvienMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblNvien);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnThem))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtTImKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(btnTim))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnSua)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                                .addComponent(txtGioiTinh, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                                    .addComponent(txtSdt)
                                                    .addComponent(txtLuong)))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(btnXoa)
                                                .addGap(112, 112, 112)
                                                .addComponent(btnMoi)))))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTImKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (!checkLuu()) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn lưu thông tin nhân viên này không?");
        if (chon == JOptionPane.YES_OPTION) {
            try {
                NhanVien nv = new NhanVien();
                nv.setMaNV(txtMa.getText());
                nv.setTenNV(txtTen.getText());
                nv.setGioiTinh(txtGioiTinh.getText());
                nv.setSoDT(txtSdt.getText());
                nv.setEmail(txtEmail.getText());
                nv.setLuong(Double.parseDouble(txtLuong.getText()));
                NhanVienDAL save = new NhanVienDAL();
                save.themNV(nv);
                JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thất bại!");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtTen.setText("");
        txtGioiTinh.setText("");
        txtSdt.setText("");
        txtEmail.setText("");
        txtLuong.setText("");
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (!checkCapNhat()) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn cập nhật thông tin nhân viên này không?");
        if (chon == JOptionPane.YES_OPTION) {
            try {
                NhanVien nv = new NhanVien();
                nv.setMaNV(txtMa.getText());
                nv.setTenNV(txtTen.getText());
                nv.setGioiTinh(txtGioiTinh.getText());
                nv.setSoDT(txtSdt.getText());
                nv.setEmail(txtEmail.getText());
                nv.setLuong(Double.parseDouble(txtLuong.getText()));
                NhanVienDAL update = new NhanVienDAL();
                update.suaNV(nv);
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thất bại!");
            }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (!checkXoa()) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa thông tin nhân viên này không?");
        if (chon == JOptionPane.YES_OPTION) {
            try {
                NhanVienDAL delete = new NhanVienDAL();
                boolean ketQuaXoa = delete.xoaNV(txtMa.getText());
                if (ketQuaXoa) {
                    JOptionPane.showMessageDialog(this, "Xóa thông tin nhân viên thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên để xóa!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thông tin nhân viên thất bại!");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        if (!checkTimKiem()) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn tìm kiếm thông tin nhân viên này không?");
        if (chon == JOptionPane.YES_OPTION) {
            try {
                NhanVienDAL search = new NhanVienDAL();
                NhanVien nv = search.timNV(txtMa.getText());
                if (search.timNV(txtMa.getText()) != null) {
                    txtMa.setText(nv.getMaNV());
                    txtTen.setText(nv.getTenNV());
                    txtGioiTinh.setText(nv.getGioiTinh());
                    txtSdt.setText(nv.getSoDT());
                    txtEmail.setText(nv.getEmail());
                    txtLuong.setText(String.valueOf(nv.getLuong()));
                    JOptionPane.showMessageDialog(this, "Tìm kiếm thông tin nhân viên thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Tìm kiếm thông tin nhân viên thất bại!");
                e.printStackTrace();

            }
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblNvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNvienMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblNvien.getSelectedRow();
        if (selectedRow >= 0) {
            fillToTable(selectedRow);
        }
    }//GEN-LAST:event_tblNvienMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblNvien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTImKiem;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
