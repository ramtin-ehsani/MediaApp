package com.myapp.mediaproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.myapp.mediaproject.R;
import com.myapp.mediaproject.SerialPage;
import com.myapp.mediaproject.SeriesClass;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class RVAdapterSeries2 extends
        RecyclerView.Adapter<RVAdapterSeries2.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView movieName;
        public ImageView moviePoster;
        public LinearLayout movieListFrag;

        public ViewHolder(View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.poster);
            movieName = itemView.findViewById(R.id.movieName);
            movieListFrag = itemView.findViewById(R.id.movieListFrag);
        }
    }

    private List<SeriesClass> series;
    Context context;

    public RVAdapterSeries2(List<SeriesClass> series, Context context) {
        this.series = series;this.context = context;
    }

    @Override
    public RVAdapterSeries2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.rec_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final SeriesClass serial = series.get(position);

        ImageView wordImageView = holder.moviePoster;
        wordImageView.setImageDrawable(serial.poster.getDrawable());

        final TextView nameView = holder.movieName;
        nameView.setText(serial.name + "\n" + serial.year);

        LinearLayout movieList = holder.movieListFrag;
        movieList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SerialPage.class);
                intent.putExtra("name", serial.name);
                intent.putExtra("year", serial.year);
                intent.putExtra("description", serial.description);
                intent.putExtra("director", serial.director);
                intent.putExtra("stars", serial.stars);
                intent.putExtra("imdbRating", serial.imdbRating);
                intent.putExtra("RTrating", serial.RTrating);
                intent.putExtra("genre", serial.genre);
                intent.putExtra("link", serial.imdbLink);
                intent.putExtra("seasonNo", serial.seasons.size());

                Bitmap bitmap = BitmapFactory.decodeResource
                        (serial.poster.getResources(), (int) serial.poster.getTag()); // your bitmap
                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
                intent.putExtra("image", bs.toByteArray());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return series.size();
    }
}