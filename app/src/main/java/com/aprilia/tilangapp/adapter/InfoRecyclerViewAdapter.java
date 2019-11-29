package com.aprilia.tilangapp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aprilia.tilangapp.Model.InfoTilang;
import com.aprilia.tilangapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class InfoRecyclerViewAdapter extends RecyclerView.Adapter<InfoRecyclerViewAdapter.ViewHolder> {

    public ArrayList<InfoTilang> infoTilang;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView tilangImage;
        public TextView namaKegiatan,jadwal,lokasi,desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaKegiatan = itemView.findViewById(R.id.kegiatan);
            jadwal = itemView.findViewById(R.id.jadwalTilang);
            lokasi = itemView.findViewById(R.id.lokasi);
            desc = itemView.findViewById(R.id.desc);
            tilangImage = itemView.findViewById(R.id.Image);
        }
    }

    public InfoRecyclerViewAdapter(ArrayList<InfoTilang> infoTilang) {
        this.infoTilang = infoTilang;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardinfo, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            Picasso
                    .get()
                    .load("https://aplikasitilang.herokuapp.com/storage/img/" + infoTilang.get(position).getImage())
                    .into((ImageView) holder.tilangImage, new Callback() {
                        @Override
                        public void onSuccess()
                        {
//                            holder.progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d("picasso failed", e.toString());
//                            holder.progressBar.setVisibility(View.GONE);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.namaKegiatan.setText(infoTilang.get(position).getNamaKegiatan());
        holder.jadwal.setText(infoTilang.get(position).getTanggal());
        holder.lokasi.setText(infoTilang.get(position).getLokasi());
        holder.desc.setText(infoTilang.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return infoTilang.size();
    }






}
