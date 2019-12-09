package com.aprilia.tilangapp.ui.infotilang;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aprilia.tilangapp.Model.InfoTilang;
import com.aprilia.tilangapp.R;
import com.aprilia.tilangapp.adapter.InfoRecyclerViewAdapter;
import com.aprilia.tilangapp.data.APIService;
import com.aprilia.tilangapp.data.APIWeb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class InfoTilangFragment extends Fragment {

    private RecyclerView recyclerView;
    private com.aprilia.tilangapp.adapter.InfoRecyclerViewAdapter InfoRecyclerViewAdapter;
    private ArrayList<InfoTilang> infoTilang;
    private GridLayoutManager gridLayoutManager;

    public InfoTilangFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info_tilang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);

        getInfo();
    }

    private void getInfo() {
        APIService apiService = APIWeb.getRetrofit(APIWeb.BASE_URL).create(APIService.class);
        final Call<ResponseBody> infoTilangResponseCall = apiService.getInfo();
        infoTilangResponseCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String bodyString = null;
                try {
                    bodyString = response.body() != null ? response.body().string() : response.errorBody().string();
                    Log.d("TesHasilJSON", bodyString);
                    JSONObject bodyJSON = new JSONObject(bodyString);
                    infoTilang = new ArrayList<>();
                    JSONArray result = bodyJSON.getJSONArray("result");

                    //isi InfoTilang;
                    for (int i = 0; i < result.length(); i++) {
//                            public InfoTilang(String id, String image, String namaKegiatan, String tanggal, String tanggalEnd, String lokasi, String desc){
                        JSONObject dataResult = result.getJSONObject(i);
                        infoTilang.add(new InfoTilang(dataResult.getString("id"), dataResult.getString("foto"), dataResult.getString("nama"),
                                dataResult.getString("tanggal_mulai"), dataResult.getString("tanggal_selesai"), dataResult.getString("lokasi"),
                                dataResult.getString("keterangan")));
                    }
                    initInfoList();

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("infoDataTilang", t.toString());
            }
        });
    }

    private void initInfoList() {
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        InfoRecyclerViewAdapter = new InfoRecyclerViewAdapter(infoTilang);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(InfoRecyclerViewAdapter);
    }
}
