/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SanPham;
import Model.DataProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class SanPhamDAL {
    public boolean insertSP(SanPham sp){
        String sql="insert into SASPHAM(MaSP, TenSP, Hang, LoaiSP, PhanLoai, SIze, ChiPhi, TinhTrang, Mota) values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try {
            Connection conn1= DataProvider.GetDataConnection();
            PreparedStatement preStm1= conn1.prepareStatement(sql);
            preStm1.setString(1, sp.getMaSP());
            preStm1.setString(2, sp.getTenSP());
            preStm1.setString(3, sp.getHang());
            preStm1.setString(4, sp.getLoaiSP());
            preStm1.setString(5, sp.getPhanLoai());
            preStm1.setInt(6, sp.getSize());
            preStm1.setDouble(7, sp.getChiPhi());
            preStm1.setString(8, sp.getTinhTrang());
            preStm1.setString(9, sp.getMotaChiTiet());
            return preStm1.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateSP(SanPham sp){
        String sql="Update SANPHAM set MaSP=?, TenSP=?, Hang=?, LoaiSP=?, PhanLoai=?, SIze=?, ChiPhi=?, TinhTrang=?, Mota=?";
        try {
            Connection conn2= DataProvider.GetDataConnection();
            PreparedStatement preStm2= conn2.prepareStatement(sql);
            preStm2.setString(1, sp.getMaSP());
            preStm2.setString(2, sp.getTenSP());
            preStm2.setString(3, sp.getHang());
            preStm2.setString(4, sp.getLoaiSP());
            preStm2.setString(5, sp.getPhanLoai());
            preStm2.setInt(6, sp.getSize());
            preStm2.setDouble(7, sp.getChiPhi());
            preStm2.setString(8, sp.getTinhTrang());
            preStm2.setString(9, sp.getMotaChiTiet());
            return preStm2.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    } 
    public boolean deleteSP(String maSP){
         String sql = "Delete from SANPHAM where MaSP = ?";
         try {
            Connection conn3 = DataProvider.GetDataConnection();
            PreparedStatement preStm3 = conn3.prepareStatement(sql);
            preStm3.setString(1, maSP);

            return preStm3.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }
     public SanPham searchSp(String maSP) {
        String sql = "Select * from SANPHAM where MaSP=?";
        try {
            Connection conn4 = DataProvider.GetDataConnection();
            PreparedStatement preStm4 = conn4.prepareStatement(sql);
            preStm4.setString(1, maSP);
            ResultSet rs = preStm4.executeQuery();
            if (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setHang(rs.getString("Hang"));
                sp.setLoaiSP(rs.getString("LoaiSP"));
                sp.setPhanLoai(rs.getString("PhanLoai"));
                sp.setSize(Integer.parseInt(rs.getString("Size")));
                sp.setChiPhi(Double.parseDouble(rs.getString("ChiPhi")));
                sp.setTinhTrang(rs.getString("TinhTrang"));
                sp.setMotaChiTiet(rs.getString("MoTa"));
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }      
}
