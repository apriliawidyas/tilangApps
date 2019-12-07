package com.aprilia.tilangapp.data;

import com.aprilia.tilangapp.Model.infoTilangResponse;
import com.google.gson.JsonElement;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface APIService {

    //registrasi
//    @FormUrlEncoded
//    @POST("public/api/register")
//    Call<JsonElement> register(
//            @Field("name") String name,
//            @Field("username") String username,
//            @Field("password") String password,
//            @Field("no_sim") String no_sim
//    );
    @Multipart
    @POST("public/api/register")
    Call<ResponseBody> register(@PartMap Map<String, RequestBody> params);

    //login
    @Multipart
    @POST("public/api/login")
    Call<ResponseBody> login(@PartMap Map<String, RequestBody> params);

    //info tilang
    @GET("public/dataInfoTilang")
    Call<ResponseBody> getInfo();

}
