package com.aprilia.tilangapp;

import android.os.Bundle;

import com.aprilia.tilangapp.Model.InfoTilang;
import com.aprilia.tilangapp.adapter.InfoRecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private InfoRecyclerViewAdapter InfoRecyclerViewAdapter;
    private ArrayList<InfoTilang> infoTilangResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

//    private void getInfo(){
//        APIService apiService = APIWeb.getRetrofit().create(APIService.class);
//        final Call<infoTilangResponse> infoTilangResponseCall = apiService.getInfo();
//        infoTilangResponseCall.enqueue(new Callback<infoTilangResponse>() {
//            @Override
//            public void onResponse(Call<infoTilangResponse> call, Response<infoTilangResponse> response) {
//                infoTilangResponse = response.body().getResults();
//                Log.d("infoDataTilang", response.body().toString());
//
//                initInfoList();
//
//            }
//
//            @Override
//            public void onFailure(Call<infoTilangResponse> call, Throwable t) {
//                Log.d("infoDataTilang", t.toString());
//            }
//        });
//    }

//    private void initInfoList() {
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        InfoRecyclerViewAdapter = new InfoRecyclerViewAdapter(infoTilangResponse);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(InfoRecyclerViewAdapter);
//    }

}
