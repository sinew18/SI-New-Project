package com.example.sinewproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private Context context;
    private ArrayList<RecyclerModel> dataFilm;
    public RecyclerAdapter(Context context, ArrayList<RecyclerModel> dataFilm) {
        this.context = context;
        this.dataFilm = dataFilm;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position){
        final RecyclerModel recyclerModels = dataFilm.get(position);
        holder.txtNama.setText(recyclerModels.getNamaFilm());
        holder.txtTahun.setText(recyclerModels.getTahunFilm());
        holder.txtMenit.setText(recyclerModels.getDurasiMenit());
        holder.cardClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailRecycler.class);
                intent.putExtra("nama_film", holder.txtNama.getText().toString());
                intent.putExtra("tahun_film", holder.txtTahun.getText().toString());
                intent.putExtra("durasi_menit", holder.txtMenit.getText().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataFilm.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtTahun, txtMenit;
        private CardView cardClick;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            txtNama = itemView.findViewById(R.id.judulFilm);
            txtTahun = itemView.findViewById(R.id.tahunFilm);
            txtMenit = itemView.findViewById(R.id.durasiMenit);
            cardClick = itemView.findViewById(R.id.carview_click);
        }
    }
}
