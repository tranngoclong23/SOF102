/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.DataProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.NhanVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDAL {

    public boolean themNV(NhanVien nv) {
        String sql = "Insert into NHANVIEN (MaNV, TenNV, GioiTinh, SoDT, Email, Luong) values(?, ?, ?, ?, ?, ?) ";
        try {
            Connection conn1 = DataProvider.GetDataConnection();
            PreparedStatement preStm1 = conn1.prepareStatement(sql);
            preStm1.setString(1, nv.getMaNV());
            preStm1.setString(2, nv.getTenNV());
            preStm1.setString(3, nv.getGioiTinh());
            preStm1.setString(4, nv.getSoDT());
            preStm1.setString(5, nv.getEmail());
            preStm1.setDouble(6, nv.getLuong());
            return preStm1.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suaNV(NhanVien nv) {
        String sql = "Update NHANVIEN set MaNV = ?, TenNV = ?, GioiTinh = ?, SoDT = ?, Email = ?, Luong = ?";
        try {
            Connection conn2 = DataProvider.GetDataConnection();
            PreparedStatement preStm2 = conn2.prepareStatement(sql);
            preStm2.setString(1, nv.getMaNV());
            preStm2.setString(2, nv.getTenNV());
            preStm2.setString(3, nv.getGioiTinh());
            preStm2.setString(4, nv.getSoDT());
            preStm2.setString(5, nv.getEmail());
            preStm2.setDouble(6, nv.getLuong());
            return preStm2.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xoaNV(String maNV) {
        String sql = "Delete from NHANVIEN where MaNV = ?";
        try {
            Connection conn3 = DataProvider.GetDataConnection();
            PreparedStatement preStm3 = conn3.prepareStatement(sql);
            preStm3.setString(1, maNV);

            return preStm3.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public NhanVien timNV(String maNV) {
        String sql = "Select * from NHANVIEN where MaNV = ?";
        try {
            Connection conn4 = DataProvider.GetDataConnection();
            PreparedStatement preStm4 = conn4.prepareStatement(sql);
            preStm4.setString(1, maNV);
            ResultSet rs = preStm4.executeQuery();
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setSoDT(rs.getString("SoDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setLuong(Double.parseDouble(rs.getString("Luong")));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
