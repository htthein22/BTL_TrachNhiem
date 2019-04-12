package com.htt22.btl_trachnhiem.CauHoi;

public class CauHoi {
    private int id;
    private String cauhoi;
    private String a;
    private String b;
    private String c;
    private String d;
    private String ketqua;
    private String anh;
    private int sode;
    private String monhoc;

    public CauHoi(){

    }

    public CauHoi(int id, String cauhoi, String a, String b, String c, String d, String ketqua, String anh, int sode, String monhoc) {
        this.id = id;
        this.cauhoi = cauhoi;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.ketqua = ketqua;
        this.anh = anh;
        this.sode = sode;
        this.monhoc = monhoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getSode() {
        return sode;
    }

    public void setSode(int sode) {
        this.sode = sode;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }
}
