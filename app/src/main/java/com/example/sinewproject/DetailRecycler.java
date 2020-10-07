package com.example.sinewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailRecycler extends AppCompatActivity {
    private TextView judulFilm;
    private TextView tahunFilm;
    private TextView durasiMenit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recycler);
        initView();
        judulFilm.setText(getIntent().getStringExtra("nama_film"));
        tahunFilm.setText(getIntent().getStringExtra("tahun_film"));
        durasiMenit.setText(getIntent().getStringExtra("durasi_menit"));
    }

    private void initView() {
        judulFilm = findViewById(R.id.judulFilm);
        tahunFilm = findViewById(R.id.tahunFilm);
        durasiMenit = findViewById(R.id.durasiMenit);
    }
}