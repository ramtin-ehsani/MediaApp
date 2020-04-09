package com.myapp.mediaproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.myapp.mediaproject.adapters.RVAdapterMovies;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    Intent intent;
    RVAdapterMovies adapter;
    ProgressBar progressBar;

    static String query;

    private List<MoviesClass> movies = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ChildEventListener childEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        init();
        handle();

    }

    private void init() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("movies");

        searchView = findViewById(R.id.edt_search);
        recyclerView = findViewById(R.id.rvMovies);
        progressBar = findViewById(R.id.prBar1);

        recyclerView.setVisibility(View.INVISIBLE);

        intent = getIntent();
        query = intent.getStringExtra("search");
        searchView.setQuery(query,false);
    }

    private void handle() {
        attachData(query);

        adapter = new RVAdapterMovies(movies, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                movies.clear();
                adapter.notifyDataSetChanged();
                if (childEventListener != null){
                    databaseReference.removeEventListener(childEventListener);
                    childEventListener = null;
                }
                attachData(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void attachData(final String query){
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
        if (childEventListener == null){
            childEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    if (dataSnapshot.exists()){
                            MovieFirebase movie = dataSnapshot.getValue(MovieFirebase.class);
                            String movieName = movie.name.toLowerCase();
                            if (movieName.contains(query.toLowerCase())){
                                movies.add(new MoviesClass(movie.name,movie.year,movie.description,movie.director,
                                        movie.stars,movie.imdbRating,movie.RTrating,new ImageView(getBaseContext()),movie.genre,
                                        movie.imdbLink,movie.link720p,movie.link1080p,movie.imageLink));
                                adapter.notifyDataSetChanged();
                            }
                        Log.v("movie1",movies.size()+"");
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };
            databaseReference.addChildEventListener(childEventListener);
            new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.INVISIBLE);
                        recyclerView.setVisibility(View.VISIBLE);
                        if (movies.size() == 0)
                            Toast.makeText(SearchActivity.this, "not found!", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
        }

    }
}
