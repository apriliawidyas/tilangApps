package com.aprilia.tilangapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aprilia.tilangapp.Model.daftarPelanggar;
import com.aprilia.tilangapp.R;

import java.util.ArrayList;

public class DaftarRecyclerViewAdapter extends RecyclerView.Adapter<DaftarRecyclerViewAdapter.ViewHolder> {

    public ArrayList<daftarPelanggar> daftarPelanggar;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView namaPelanggar,plat,lokasiTilang,tanggal,pelanggaran,lokasiSidang,namaPolisi,noSim;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaPelanggar = itemView.findViewById(R.id.nama);
            noSim = itemView.findViewById(R.id.no_sim);
            plat = itemView.findViewById(R.id.plat);
            lokasiTilang = itemView.findViewById(R.id.lokasiTilang);
            tanggal = itemView.findViewById(R.id.tanggal);
            pelanggaran = itemView.findViewById(R.id.pelanggaran);
            lokasiSidang = itemView.findViewById(R.id.lokasiSidang);
            namaPolisi = itemView.findViewById(R.id.namaPolisi);
        }
    }

    public DaftarRecyclerViewAdapter(ArrayList<com.aprilia.tilangapp.Model.daftarPelanggar> daftarPelanggar) {
        this.daftarPelanggar = daftarPelanggar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_daftar, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namaPelanggar.setText(daftarPelanggar.get(position).getNama());
        holder.noSim.setText(daftarPelanggar.get(position).getNo_sim());
        holder.plat.setText(daftarPelanggar.get(position).getPlat_nomor());
        holder.lokasiTilang.setText(daftarPelanggar.get(position).getLokasi_tilang());
        holder.tanggal.setText(daftarPelanggar.get(position).getTanggal_sidang());
        holder.pelanggaran.setText(daftarPelanggar.get(position).getPelanggaran());
        holder.lokasiSidang.setText(daftarPelanggar.get(position).getLokasi_sidang());
        holder.namaPolisi.setText(daftarPelanggar.get(position).getNama_polisi());

    }

    @Override
    public int getItemCount() {
        return daftarPelanggar.size();
    }
}
