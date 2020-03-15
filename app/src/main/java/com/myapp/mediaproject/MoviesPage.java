package com.myapp.mediaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MoviesPage extends AppCompatActivity {

    MoviesClass movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_page);

        init();
    }


    public void init()
    {
        Intent intent = getIntent();

        ImageView imv= new ImageView(this);
        Bitmap bitmap = BitmapFactory.decodeByteArray(
                getIntent().getByteArrayExtra("image"), 0, getIntent().getByteArrayExtra("image").length);
        imv.setImageBitmap(bitmap);

        movie = new MoviesClass(intent.getStringExtra("name"), intent.getStringExtra("year"),
                intent.getStringExtra("description"), intent.getStringExtra("director"), intent.getStringExtra("stars"),
                intent.getStringExtra("imdbRating"), intent.getStringExtra("RTrating"), imv, intent.getStringExtra("genre"),
                intent.getStringExtra("link"),intent.getStringExtra("link720p"),intent.getStringExtra("link1080p"));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        findViewById(R.id.moviePoster).setBackground(movie.poster.getDrawable());
        TextView nameTxtView = findViewById(R.id.movieName);
        nameTxtView.setText(movie.name);

        TextView yearTxtView = findViewById(R.id.movieYear);
        yearTxtView.setText(movie.year);

        TextView directorTxtView = findViewById(R.id.movieDirector);
        directorTxtView.setText(movie.director);

        TextView starsTxtView = findViewById(R.id.movieStars);
        starsTxtView.setText(movie.stars);

        TextView imdbTxtView = findViewById(R.id.movieIMDBRating);
        imdbTxtView.setText(movie.imdbRating);

        TextView rtTxtView = findViewById(R.id.movieRTRating);
        rtTxtView.setText(movie.RTrating);

        TextView genreTxtView = findViewById(R.id.movieGenre);
        genreTxtView.setText(movie.genre);

        TextView descriptionTxtView = findViewById(R.id.movieDescription);
        descriptionTxtView.setText(movie.description);

        findViewById(R.id.moviePoster).setLayoutParams(new RelativeLayout.LayoutParams(width, height - 20));

        findViewById(R.id.backBTNMovies).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.imdbMovieLink).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.imdbLink));
                startActivity(intent);
            }
        });

        Button btn720p = findViewById(R.id.btn720p);
        btn720p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.link720));
                startActivity(intent);
            }
        });

        Button btn1080p = findViewById(R.id.btn1080p);
        btn1080p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.link1080p));
                startActivity(intent);
            }
        });
    }
}
