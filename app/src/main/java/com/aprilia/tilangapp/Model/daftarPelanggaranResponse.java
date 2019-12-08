package com.aprilia.tilangapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class daftarPelanggaranResponse {

    @SerializedName("results")
    private ArrayList<daftarPelanggar> daftarPelanggarArrayList;

    public ArrayList<daftarPelanggar> getResults() {

        return daftarPelanggarArrayList;
    }
}
