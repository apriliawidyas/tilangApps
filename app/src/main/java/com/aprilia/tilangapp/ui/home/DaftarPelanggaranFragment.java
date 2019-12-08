package com.aprilia.tilangapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class DaftarPelanggaranFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<daftarPelanggar> daftarPelanggaran;
    private DaftarRecyclerViewAdapter DaftarRecyclerViewAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.card_daftar, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);
        Log.d("TesRecycle", "jalan");
        //panggil methodnya
//        adapter();
        getPelanggaran();
    }

    private void getPelanggaran(){
        APIService apiService = APIWeb.getRetrofit(APIWeb.BASE_URL2).create(APIService.class);
        final Call<ResponseBody> daftarPelanggaranResponseCall = apiService.getPelanggaran();
        daftarPelanggaranResponseCall.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String bodyString = null;
                try {
                    bodyString = response.body() != null ? response.body().string() : response.errorBody().string();
                    Log.d("TesHasilJSON", bodyString);
                    JSONObject bodyJSON = new JSONObject(bodyString);
                    daftarPelanggaran = new ArrayList<>();
                    JSONArray result = bodyJSON.getJSONArray("result");

                    //isi InfoTilang;
                    for (int i = 0; i < result.length(); i++) {
//    public daftarPelanggar(String id, String nama, String no_sim, String plat_nomor, String lokasi_tilang, String lokasi_sidang, String pelanggaran, String nama_polisi, String tanggal_sidang) {
                        JSONObject dataResult = result.getJSONObject(i);
                        daftarPelanggaran.add(new daftarPelanggar(dataResult.getString("id"), dataResult.getString("nama"), dataResult.getString("no_sim"),
                                dataResult.getString("plat_nomor"), dataResult.getString("lokasi_tilang"), dataResult.getString("lokasi_sidang"),
                                dataResult.getString("pelanggaran"), dataResult.getString("nama_polisi"),dataResult.getString("tanggal_sidang")));
                    }
                    initDaftarList();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
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
