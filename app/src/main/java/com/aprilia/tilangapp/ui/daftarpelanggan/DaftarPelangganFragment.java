package com.aprilia.tilangapp.ui.daftarpelanggan;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aprilia.tilangapp.LoginActivity;
import com.aprilia.tilangapp.Model.daftarPelanggar;
import com.aprilia.tilangapp.R;
import com.aprilia.tilangapp.adapter.DaftarRecyclerViewAdapter;
import com.aprilia.tilangapp.data.APIService;
import com.aprilia.tilangapp.data.APIWeb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarPelangganFragment extends Fragment {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<daftarPelanggar> daftarPelanggaran;
    private com.aprilia.tilangapp.adapter.DaftarRecyclerViewAdapter DaftarRecyclerViewAdapter;
    private android.preference.PreferenceManager PreferenceManager;

    public DaftarPelangganFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_daftar_pelanggan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview2);

        getPelanggaran();
    }

    private void getPelanggaran() {
        APIService apiService = APIWeb.getRetrofit(APIWeb.BASE_URL2).create(APIService.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Authenticate", Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token", "");
        final Call<ResponseBody> daftarPelanggaranResponseCall = apiService.getAuthorizedDriver(token);
        Log.d("Token1",token);
        daftarPelanggaranResponseCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String bodyString = null;
                Log.d("Cobacall","respon");
                try {
                    bodyString = response.body() != null ? response.body().string() : response.errorBody().string();
                    Log.d("TesHasiDaftar", bodyString);
                    JSONObject bodyJSON = new JSONObject(bodyString);
                    Log.d("TesHasiDaftar", "0");
                    daftarPelanggaran = new ArrayList<>();
                    Log.d("TesHasiDaftar1", "1");
                    JSONArray result = bodyJSON.getJSONArray("result");
                    Log.d("TesHasiDaftar2", "2");

//                    //isi InfoTilang;
                    for (int i = 0; i < result.length(); i++) {
//    public daftarPelanggar(String id, String nama, String no_sim, String plat_nomor, String lokasi_tilang, String lokasi_sidang, String pelanggaran, String nama_polisi, String tanggal_sidang) {
                        JSONObject dataResult = result.getJSONObject(i);
                        daftarPelanggaran.add(new daftarPelanggar(dataResult.getString("id"), dataResult.getString("nama"), dataResult.getString("no_sim"),
                                dataResult.getString("plat_nomor"), dataResult.getString("lokasi_tilang"), dataResult.getString("lokasi_sidang"),
                                dataResult.getString("pelanggaran"), dataResult.getString("nama_polisi"),dataResult.getString("tanggal_sidang")));
                    }
                    initDaftarList();
                } catch (IOException e) {
                    Log.d("exception",e.getMessage());
                    e.printStackTrace();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("infoPelanggaran", t.toString());

            }
        });

    }

    private void initDaftarList() {
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        linearLayoutManager = new LinearLayoutManager(getContext());
        DaftarRecyclerViewAdapter = new DaftarRecyclerViewAdapter(daftarPelanggaran);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(DaftarRecyclerViewAdapter);
    }
}
