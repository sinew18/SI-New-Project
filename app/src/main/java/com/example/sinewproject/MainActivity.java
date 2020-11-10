package com.example.sinewproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {
    private static String JSON_URL = "https://api.themoviedb.org/3/movie/popular?api_key=0dde3e9896a8c299d142e214fcb636f8";
    private List<ResultsItem> filmArray;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        filmArray = new ArrayList<>();
        getData();
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject filmObject = response.getJSONObject(i);
                        ResultsItem recyclerModel = new ResultsItem();
                        recyclerModel.setPopularity(filmObject.getInt("popularity"));
                        recyclerModel.setVoteCount(filmObject.getInt("vote_count"));
                        recyclerModel.setId(filmObject.getInt("id"));
                        recyclerModel.setOriginalLanguage(filmObject.getString("original_language").toString());
                        recyclerModel.setOriginalTitle(filmObject.getString("original_title").toString());
                        recyclerModel.setTitle(filmObject.getString("title").toString());
                        recyclerModel.setReleaseDate(filmObject.getString("release_date").toString());
                        recyclerModel.setOverview(filmObject.getString("overview").toString());
                        filmArray.add(recyclerModel);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                RecyclerAdapter adapter = new RecyclerAdapter(getApplicationContext(), filmArray);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }
}