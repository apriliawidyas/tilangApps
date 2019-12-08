package com.aprilia.tilangapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class daftarPelanggar {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("no_sim")
    @Expose
    private String no_sim;
    @SerializedName("plat_nomor")
    @Expose
    private String plat_nomor;
    @SerializedName("lokasi_tilang")
    @Expose
    private String lokasi_tilang;
    @SerializedName("lokasi_sidang")
    @Expose
    private String lokasi_sidang;
    @SerializedName("pelanggaran")
    @Expose
    private String pelanggaran;
    @SerializedName("nama_polisi")
    @Expose
    private String nama_polisi;
    @SerializedName("tanggal_sidang")
    @Expose
    private String tanggal_sidang;

    public daftarPelanggar(String id, String nama, String no_sim, String plat_nomor, String lokasi_tilang, String lokasi_sidang, String pelanggaran, String nama_polisi, String tanggal_sidang) {
        this.id = id;
        this.nama = nama;
        this.no_sim = no_sim;
        this.plat_nomor = plat_nomor;
        this.lokasi_tilang = lokasi_tilang;
        this.lokasi_sidang = lokasi_sidang;
        this.pelanggaran = pelanggaran;
        this.nama_polisi = nama_polisi;
        this.tanggal_sidang = tanggal_sidang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_sim() {
        return no_sim;
    }

    public void setNo_sim(String no_sim) {
        this.no_sim = no_sim;
    }

    public String getPlat_nomor() {
        return plat_nomor;
    }

    public void setPlat_nomor(String plat_nomor) {
        this.plat_nomor = plat_nomor;
    }

    public String getLokasi_tilang() {
        return lokasi_tilang;
    }

    public void setLokasi_tilang(String lokasi_tilang) {
        this.lokasi_tilang = lokasi_tilang;
    }

    public String getLokasi_sidang() {
        return lokasi_sidang;
    }

    public void setLokasi_sidang(String lokasi_sidang) {
        this.lokasi_sidang = lokasi_sidang;
    }

    public String getPelanggaran() {
        return pelanggaran;
    }

    public void setPelanggaran(String pelanggaran) {
        this.pelanggaran = pelanggaran;
    }

    public String getNama_polisi() {
        return nama_polisi;
    }

    public void setNama_polisi(String nama_polisi) {
        this.nama_polisi = nama_polisi;
    }

    public String getTanggal_sidang() {
        return tanggal_sidang;
    }

    public void setTanggal_sidang(String tanggal_sidang) {
        this.tanggal_sidang = tanggal_sidang;
    }

}
