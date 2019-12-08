package com.aprilia.tilangapp.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoTilang {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("foto")
    @Expose
    private String image;
    @SerializedName("nama")
    @Expose
    private String namaKegiatan;
    @SerializedName("tanggal_mulai")
    @Expose
    private String tanggal;
    @SerializedName("tanggal_selesai")
    @Expose
    private String tanggalEnd;
    @SerializedName("lokasi")
    @Expose
    private String lokasi;
    @SerializedName("keterangan")
    @Expose
    private String desc;

    public InfoTilang(String id, String image, String namaKegiatan, String tanggal, String tanggalEnd, String lokasi, String desc){
        this.id = id;
        this.image = image;
        this.namaKegiatan = namaKegiatan;
        this.tanggal = tanggal;
        this.tanggalEnd = tanggalEnd;
        this.lokasi = lokasi;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggalEnd() {
        return tanggalEnd;
    }

    public void setTanggalEnd(String tanggalEnd) {
        this.tanggalEnd = tanggalEnd;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
