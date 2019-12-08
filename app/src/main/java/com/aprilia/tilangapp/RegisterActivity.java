package com.aprilia.tilangapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.aprilia.tilangapp.data.APIService;
import com.aprilia.tilangapp.data.APIWeb;
import com.aprilia.tilangapp.ui.home.HomeFragment;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private APIService mService;
    private TextView username, password, no_sim, nama;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInsanceState) {

        super.onCreate(savedInsanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.eUsername);
        password = findViewById(R.id.ePassword);
        no_sim = findViewById(R.id.esim);
        nama = findViewById(R.id.reg_namalengkap);
        registerButton = findViewById(R.id.bRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    @SuppressLint("regist")
    private void register() {
        APIService apiService = APIWeb.getRetrofit(APIWeb.BASE_URL2).create(APIService.class);
        final String usernameString = username.getText().toString();
        final String namaString = nama.getText().toString();
        final String noSim = no_sim.getText().toString();
        final String passwordString = password.getText().toString();
        final Map<String, RequestBody> requestFormData = new HashMap<>();

        requestFormData.put("name", RequestBody.create(MediaType.parse("multipart/form-data"),namaString ));
        requestFormData.put("username", RequestBody.create(MediaType.parse("multipart/form-data"), usernameString));
        requestFormData.put("no_sim", RequestBody.create(MediaType.parse("multipart/form-data"), noSim));
        requestFormData.put("password", RequestBody.create(MediaType.parse("multipart/form-data"), passwordString));

        final Call<ResponseBody> registUser = apiService.register(requestFormData);
        registUser.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String bodyString = response.body() != null ? response.body().string() : response.errorBody().string();
                    Log.d("CreateRegist", call.request().url().toString());
                    Log.d("CreateRegist", bodyString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("CreateRegist", call.request().url().toString());
            }
        });
    }

}
