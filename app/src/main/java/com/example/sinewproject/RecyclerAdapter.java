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
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private final Context context;
    LayoutInflater layoutInflater;
    private final List<ResultsItem> dataFilm;
    public RecyclerAdapter(Context context, List<ResultsItem> dataFilm) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.dataFilm = dataFilm;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position){
        holder.title.setText(dataFilm.get(position).getTitle());
        holder.release_date.setText(dataFilm.get(position).getReleaseDate());
        holder.cardClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailRecycler.class);
                holder.id.setText(dataFilm.get(position).getId());
                holder.original_title.setText(dataFilm.get(position).getOriginalTitle());
                holder.original_language.setText(dataFilm.get(position).getOriginalLanguage());
                holder.popularity.setText((int) dataFilm.get(position).getPopularity());
                holder.vote_count.setText(dataFilm.get(position).getVoteCount());
                holder.overview.setText(dataFilm.get(position).getOverview());
                intent.putExtra("id", holder.id.getText().toString());
                intent.putExtra("nama_film", holder.title.getText().toString());
                intent.putExtra("tahun_film", holder.release_date.getText().toString());
                intent.putExtra("original_title", holder.original_title.getText().toString());
                intent.putExtra("original_language", holder.original_language.getText().toString());
                intent.putExtra("popularity", holder.popularity.getText().toString());
                intent.putExtra("vote_count", holder.vote_count.getText().toString());
                intent.putExtra("overview", holder.overview.getText().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataFilm.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final TextView release_date;
        private TextView id;
        private TextView original_title;
        private TextView original_language;
        private TextView popularity;
        private TextView vote_count;
        private TextView overview;
        private final CardView cardClick;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.judulFilm);
            release_date = itemView.findViewById(R.id.tahunFilm);
            cardClick = itemView.findViewById(R.id.carview_click);
        }
    }
}
