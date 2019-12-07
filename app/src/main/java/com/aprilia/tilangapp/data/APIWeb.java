package com.aprilia.tilangapp.data;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIWeb {

    public static Retrofit retrofit=null;
    public static final String BASE_URL = "https://aplikasitilang.herokuapp.com/";
    public static final String BASE_URL2 = "https://info-tilang.herokuapp.com/";

    public static Retrofit getRetrofit(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    //ini retrofit untuk url yang ditambahin sendiri atau bisa pake base_url2

    public static Retrofit getRetrofit(String url) {
        if (retrofit == null || !url.equals(retrofit.baseUrl().toString())){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }else
            Log.d("createUser", retrofit.baseUrl().toString());
        return retrofit;
    }
}
