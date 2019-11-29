package com.aprilia.tilangapp.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIWeb {

    public static Retrofit retrofit=null;
    private static final String BASE_URL = "https://aplikasitilang.herokuapp.com/";

//    public static Retrofit getRetrofit(String baseURL){
//        if(retrofit == null){
//            retrofit = new Retrofit.Builder().
//                    baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).
//                    build();
//        }
//        return retrofit;
//    }

    public static Retrofit getRetrofit(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
