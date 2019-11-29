package com.aprilia.tilangapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class infoTilangResponse {

    @SerializedName("results")
    private ArrayList<InfoTilang> infoTilangArrayList;

    public ArrayList<InfoTilang> getResults() {

        return infoTilangArrayList;
    }

}
