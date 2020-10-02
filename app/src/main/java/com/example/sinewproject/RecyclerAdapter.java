package com.example.sinewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private ArrayList<RecyclerModel> dataFilm;
    public RecyclerAdapter(ArrayList<RecyclerModel> dataFilm){
        this.dataFilm = dataFilm;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position){
        holder.txtNama.setText(dataFilm.get(position).getNamaFilm());
        holder.txtTahun.setText(dataFilm.get(position).getTahunFilm());
        holder.txtMenit.setText(dataFilm.get(position).getDurasiMenit());
    }

    @Override
    public int getItemCount() {
        return (dataFilm != null) ? dataFilm.size() : 0;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtTahun, txtMenit;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.judulFilm);
            txtTahun = (TextView) itemView.findViewById(R.id.tahunFilm);
            txtMenit = (TextView) itemView.findViewById(R.id.durasiMenit);
        }
    }
}
