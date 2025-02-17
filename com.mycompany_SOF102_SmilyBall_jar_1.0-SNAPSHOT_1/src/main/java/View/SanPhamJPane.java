/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.SanPham;
import Service.SanPhamDAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class SanPhamJPane extends javax.swing.JPanel {

    /**
     * Creates new form SanPhamJPane
     */
    public SanPhamJPane() {
        initComponents();
    }
    private List<String> layDanhSachMaSP() {
        List<String> danhSachMaSP = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=SOF102_SD1808_SmileyBall";
            String user = "sa";
            String password = "123";
            conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT MaSP FROM SANPHAM";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString("MaSP");
                danhSachMaSP.add(maSP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return danhSachMaSP ;
    }
    private boolean checkTrung(String MaSP) {
        List<String> danhSachMaSP = layDanhSachMaSP();
        return danhSachMaSP.contains(MaSP);
    }
    private boolean checkSP() {
        int size = Integer.parseInt(txtSize.getText());
        double chiPhi=Double.parseDouble(txtChiPhi.getText());
        if (size <= 0) {
            JOptionPane.showMessageDialog(this, "Size sản phẩm không hợp lệ! Vui lòng nhập lại!");
            return false;
        }
        if (chiPhi <= 0) {
            JOptionPane.showMessageDialog(this, "Chí phí sản phẩm không hợp lệ! Vui lòng nhập lại!");
            return false;
        }
        return true;
    }
    private boolean checkLuu() {
        if (txtSP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống!");
            txtSP.requestFocus();
            return false;
        }
        if (checkTrung(txtSP.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không hợp lệ! Vui lòng nhập lại!");
            txtSP.requestFocus();
            return false;
        }
        
        if (txtTenSanPham.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống!");
            txtTenSanPham.requestFocus();
            return false;
        }
        
        if (txtHang.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "hãng sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (txtLoaiSanPham.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Loại sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (txtPhanLoai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phân loại sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (txtSize.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Size sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (!checkSP()) {
            txtSize.requestFocus();
            return false;
        }
        if (txtChiPhi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CHi phí sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (!checkSP()) {
            txtChiPhi.requestFocus();
            return false;
        }
        if (txtTinhTrang.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tình trạng sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (txtaMoTa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mô tả sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        return true;
    }
     private boolean checkCapNhat() {
        if (txtSP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống!");
            txtSP.requestFocus();
            return false;
        }
        
        if (txtTenSanPham.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống!");
            txtTenSanPham.requestFocus();
            return false;
        }
        
        if (txtHang.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "hãng sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (txtLoaiSanPham.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Loại sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (txtPhanLoai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phân loại sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (txtSize.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Size sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (!checkSP()) {
            txtSize.requestFocus();
            return false;
        }
        if (txtChiPhi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CHi phí sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (!checkSP()) {
            txtChiPhi.requestFocus();
            return false;
        }
        if (txtTinhTrang.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tình trạng sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        if (txtaMoTa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mô tả sản phẩm không được để trống!");
            txtHang.requestFocus();
            return false;
        }
        return true;
    }
     public boolean checkXoa(){
         if (txtSP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống!");
            txtSP.requestFocus();
            return false;
        }
         return true;
     }
     public boolean checkTimKiem() {
        if (txtTim.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điền mã sản phẩm cần tìm kiếm!");
            txtTim.requestFocus();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        txtSP = new javax.swing.JTextField();
        txtHang = new javax.swing.JTextField();
        txtPhanLoai = new javax.swing.JTextField();
        txtChiPhi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        txtLoaiSanPham = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
        txtTinhTrang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaMoTa = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Tìm kiếm");

        jLabel2.setText("Mã sản phẩm");

        jLabel3.setText("Hãng");

        jLabel4.setText("Phân loại");

        jLabel5.setText("Chi phí");

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel6.setText("Tên sản phẩm");

        jLabel7.setText("Loại sản phẩm");

        jLabel8.setText("Size");

        jLabel9.setText("Tình trạng");

        jLabel10.setText("Mô tả sản phẩm");

        txtaMoTa.setColumns(20);
        txtaMoTa.setRows(5);
        jScrollPane1.setViewportView(txtaMoTa);

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

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Hãng", "Phân loại", "Size", "Chi phí", "Tình trạng", "Mô tả"
            }
        ));
        jScrollPane2.setViewportView(tblBang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnTim))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtChiPhi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(txtPhanLoai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSP, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenSanPham)
                            .addComponent(txtLoaiSanPham)
                            .addComponent(txtSize)
                            .addComponent(txtTinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnThem)
                .addGap(95, 95, 95)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa)
                .addGap(81, 81, 81)
                .addComponent(btnMoi)
                .addGap(125, 125, 125))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtChiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnSua))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMoi)
                        .addComponent(btnXoa)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
       txtSP.setText("");
       txtTenSanPham.setText("");
       txtHang.setText("");
       txtLoaiSanPham.setText("");
       txtPhanLoai.setText("");
       txtSize.setText("");
       txtChiPhi.setText("");
       txtTinhTrang.setText("");
       txtaMoTa.setText("");
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (!checkLuu()) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn lưu thông tin sản phẩm này không?");
        if (chon == JOptionPane.YES_OPTION) {
            try {
                SanPham sp = new SanPham();
                sp.setMaSP(txtSP.getText());
                sp.setTenSP(txtTenSanPham.getText());
                sp.setHang(txtHang.getText());
                sp.setLoaiSP(txtLoaiSanPham.getText());
                sp.setPhanLoai(txtPhanLoai.getText());
                sp.setSize(Integer.parseInt(txtSize.getText()));
                sp.setChiPhi(Double.parseDouble(txtChiPhi.getText()));
                sp.setTinhTrang(txtTinhTrang.getText());
                sp.setMotaChiTiet(txtaMoTa.getText());
                SanPhamDAL save = new SanPhamDAL();
                save.insertSP(sp);
                JOptionPane.showMessageDialog(this, "Lưu thông tin sản phẩm thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lưu thông tin sản phẩm thất bại!");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (!checkCapNhat()) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn cập nhật thông tin sản phẩm này không?");
        if (chon == JOptionPane.YES_OPTION) {
            try {
                SanPham sp = new SanPham();
                sp.setMaSP(txtSP.getText());
                sp.setTenSP(txtTenSanPham.getText());
                sp.setHang(txtHang.getText());
                sp.setLoaiSP(txtLoaiSanPham.getText());
                sp.setPhanLoai(txtPhanLoai.getText());
                sp.setSize(Integer.parseInt(txtSize.getText()));
                sp.setChiPhi(Double.parseDouble(txtChiPhi.getText()));
                sp.setTinhTrang(txtTinhTrang.getText());
                sp.setMotaChiTiet(txtaMoTa.getText());
                SanPhamDAL update = new SanPhamDAL();
                update.updateSP(sp);
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin sản phẩm thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin sản phẩm thất bại!");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (!checkXoa()) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa thông tin sản phẩm này không?");
        if (chon == JOptionPane.YES_OPTION) {
            try {
                SanPhamDAL delete = new SanPhamDAL();
                boolean ketQuaXoa = delete.deleteSP(txtSP.getText());

                if (ketQuaXoa) {
                    JOptionPane.showMessageDialog(this, "Xóa thông tin sản phẩm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm sản phẩm để xóa!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thông tin sản phẩm thất bại!");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        if (!checkTimKiem()) {
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn tìm kiếm thông tin sản phẩm này không?");
        if (chon == JOptionPane.YES_OPTION) {
            try {
                SanPhamDAL search = new SanPhamDAL();
                SanPham sp = search.searchSp(txtSP.getText());
                if (search.searchSp(txtSP.getText()) != null) {
                    txtSP.setText(sp.getMaSP());
                    txtTenSanPham.setText(sp.getTenSP());
                    txtHang.setText(sp.getHang());
                    txtLoaiSanPham.setText(sp.getLoaiSP());
                    txtPhanLoai.setText(sp.getPhanLoai());
                    txtSize.setText(String.valueOf(sp.getSize()));
                    txtChiPhi.setText(String.valueOf(sp.getChiPhi()));
                    txtTinhTrang.setText(sp.getTinhTrang());
                    txtaMoTa.setText(sp.getMotaChiTiet());
                    JOptionPane.showMessageDialog(this, "Tìm kiếm thông tin sản phẩm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Mã sản phẩm không tồn tại!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Tìm kiếm thông tin sản phẩm thất bại!");
                e.printStackTrace();

            }
        }
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtChiPhi;
    private javax.swing.JTextField txtHang;
    private javax.swing.JTextField txtLoaiSanPham;
    private javax.swing.JTextField txtPhanLoai;
    private javax.swing.JTextField txtSP;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTinhTrang;
    private javax.swing.JTextArea txtaMoTa;
    // End of variables declaration//GEN-END:variables
}
