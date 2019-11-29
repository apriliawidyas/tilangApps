package com.aprilia.tilangapp.data;

import com.aprilia.tilangapp.Model.infoTilangResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("public/dataInfoTilang")
    Call<ResponseBody> getInfo();
}
