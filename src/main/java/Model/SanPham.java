/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Lenovo
 */
public class SanPham {
    private String maSP,tenSP,Hang,loaiSP,phanLoai,tinhTrang,motaChiTiet;
    private  int Size;
    private double chiPhi;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String Hang, String loaiSP, String phanLoai, String tinhTrang, String motaChiTiet, int Size, double chiPhi) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.Hang = Hang;
        this.loaiSP = loaiSP;
        this.phanLoai = phanLoai;
        this.tinhTrang = tinhTrang;
        this.motaChiTiet = motaChiTiet;
        this.Size = Size;
        this.chiPhi = chiPhi;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMotaChiTiet() {
        return motaChiTiet;
    }

    public void setMotaChiTiet(String motaChiTiet) {
        this.motaChiTiet = motaChiTiet;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }
}
