package com.myapp.mediaproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myapp.mediaproject.adapters.RVAdapterSeasons;

public class SerialPage extends AppCompatActivity {

    SeriesClass series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_page);

        init();
    }

    public void init()
    {
        Intent intent = getIntent();

        ImageView imv= new ImageView(this);
        Bitmap bitmap = BitmapFactory.decodeByteArray(
                getIntent().getByteArrayExtra("image"), 0, getIntent().getByteArrayExtra("image").length);
        imv.setImageBitmap(bitmap);

        series = new SeriesClass(intent.getStringExtra("name"), intent.getStringExtra("year"),
                intent.getStringExtra("description"), intent.getStringExtra("director"), intent.getStringExtra("stars"),
                intent.getStringExtra("imdbRating"), intent.getStringExtra("RTrating"), imv, intent.getStringExtra("genre"),
                intent.getStringExtra("link"),
                intent.getIntExtra("seasonNo", 1));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        findViewById(R.id.serialPoster).setBackground(series.poster.getDrawable());
        TextView nameTxtView = findViewById(R.id.seriesName);
        nameTxtView.setText(series.name);

        TextView yearTxtView = findViewById(R.id.seriesYear);
        yearTxtView.setText(series.year);

        TextView directorTxtView = findViewById(R.id.serialDirector);
        directorTxtView.setText(series.director);

        TextView starsTxtView = findViewById(R.id.serialStars);
        starsTxtView.setText(series.stars);

        TextView imdbTxtView = findViewById(R.id.serialIMDBPoint);
        imdbTxtView.setText(series.imdbRating);

        TextView rtTxtView = findViewById(R.id.serialRTPoints);
        rtTxtView.setText(series.RTrating);

        TextView genreTxtView = findViewById(R.id.serialGenres);
        genreTxtView.setText(series.genre);

        TextView descriptionTxtView = findViewById(R.id.serialDescription);
        descriptionTxtView.setText(series.description);


        findViewById(R.id.serialPoster).setLayoutParams(new RelativeLayout.LayoutParams(width, height - 500));


        RecyclerView rvContacts = findViewById(R.id.rvSeasons);
        RVAdapterSeasons adapter = new RVAdapterSeasons(series.seasons, this);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.backBTNSeries).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.imdbSerialLink).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(series.imdbLink));
                startActivity(intent);
            }
        });
    }


}
