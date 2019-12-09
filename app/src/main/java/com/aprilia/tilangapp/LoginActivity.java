package com.aprilia.tilangapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.aprilia.tilangapp.data.APIService;
import com.aprilia.tilangapp.data.APIWeb;
import com.aprilia.tilangapp.ui.main.MainActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button bSignup,bLogin;
    private EditText username, password;
    private APIService mAPIService;

    protected void onCreate(Bundle savedInsanceState) {

        super.onCreate(savedInsanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        bSignup = findViewById(R.id.bSignup);
        bLogin = findViewById(R.id.bLogin);

        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TryRegist", "0");
                finish();
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Validate", "1");
                if (getValidate()) {
                    login();
                }
            }
        });

    }

    private void login() {
        final String usernameLogin = username.getText().toString();
        final String passwordLogin = password.getText().toString();
        final Map<String, RequestBody> requestFormData = new HashMap<>();
        requestFormData.put("username", RequestBody.create(MediaType.parse("multipart/form-data"),usernameLogin ));
        requestFormData.put("password", RequestBody.create(MediaType.parse("multipart/form-data"),passwordLogin ));

        APIService apiService = APIWeb.getRetrofit(APIWeb.BASE_URL2).create(APIService.class);
        final Call<ResponseBody> login = apiService.login(requestFormData);
        login.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String bodyString = response.body() != null ? response.body().string() : response.errorBody().string();
                    Log.d("TryLogin", call.request().url().toString());
                    Log.d("TryLogin", bodyString);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TryLogin", call.request().url().toString());
            }
        });
    }

    private Boolean getValidate() {
        if (username.getText().toString().matches("")) {
            username.setError("Isi Username");
            return false;
        }

        if (password.getText().toString().matches("")) {
            password.setError("Isi Password");
            return false;
        }

        return true;
    }
}
