/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocLong
 */
public class KhachHangDAL {

    static String url = "jdbc:sqlserver://localhost:1433;databaseName=SOF102_SD1808_SmileyBall;user=sa;password=123";

    public static boolean insert(KhachHang kh) {
        String sql = "insert into KHACHHANG values (?,?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(url); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getGioitinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getEmail());
            ps.setString(6, kh.getDiachi());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<KhachHang> findAll(){
        String sql = "select * from KHACHHANG";
        try (Connection con = DriverManager.getConnection(url); PreparedStatement ps = con.prepareStatement(sql)) {
            List<KhachHang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                KhachHang kh = new KhachHang();
                kh.setMa(rs.getString("MaKH"));
                kh.setTen(rs.getString("TenKH"));
                kh.setGioitinh(rs.getString("GioiTinh"));
                kh.setSdt(rs.getString("SoDT"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiachi(rs.getString("DiaChi"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static KhachHang findByID(String ma){
        String sql = "select * from KHACHHANG where MaKH = ?";
        KhachHang kh = new KhachHang();
        try (Connection con = DriverManager.getConnection(url); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                kh.setMa(rs.getString("MaKH"));
                kh.setTen(rs.getString("TenKH"));
                kh.setGioitinh(rs.getString("GioiTinh"));
                kh.setSdt(rs.getString("SoDT"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiachi(rs.getString("DiaChi"));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean update(KhachHang kh){
        String sql = "update KHACHHANG set TenKH=?, GioiTinh=?, SoDT=?, Email=?, DiaChi=? where MaKH=?";
        try (Connection con = DriverManager.getConnection(url); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, kh.getTen());
            ps.setString(2, kh.getGioitinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getEmail());
            ps.setString(5, kh.getDiachi());
            ps.setString(6, kh.getMa());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<KhachHang> findKH(String maKH){
        String sql = "select * from KHACHHANG where MaKH = ?";
        try (Connection con = DriverManager.getConnection(url); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maKH);
            List<KhachHang> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                KhachHang kh = new KhachHang();
                kh.setMa(rs.getString("MaKH"));
                kh.setTen(rs.getString("TenKH"));
                kh.setGioitinh(rs.getString("GioiTinh"));
                kh.setSdt(rs.getString("SoDT"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiachi(rs.getString("DiaChi"));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
