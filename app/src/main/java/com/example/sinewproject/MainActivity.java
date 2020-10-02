package com.example.sinewproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<RecyclerModel> filmArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerAdapter adapter = new RecyclerAdapter(filmArray);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    void addData(){
        filmArray = new ArrayList<>();
        filmArray.add(new RecyclerModel("Us", "2019", "121 Menit"));
        filmArray.add(new RecyclerModel("The Conjuring", "2013", "112 Menit"));
        filmArray.add(new RecyclerModel("The Conjuring 2", "2016", "134 Menit"));
        filmArray.add(new RecyclerModel("Insidious", "2010", "102 Menit"));
    }
}