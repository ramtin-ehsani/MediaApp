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


import com.myapp.mediaproject.MoviesClass;
import com.myapp.mediaproject.MoviesPage;
import com.myapp.mediaproject.R;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class RVAdapterMovies2 extends
        RecyclerView.Adapter<RVAdapterMovies2.ViewHolder> {

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

    private List<MoviesClass> movies;
    Context context;

    public RVAdapterMovies2(List<MoviesClass> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public RVAdapterMovies2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.rec_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final MoviesClass movie = movies.get(position);

        ImageView wordImageView = holder.moviePoster;
        wordImageView.setImageDrawable(movie.poster.getDrawable());

        final TextView nameView = holder.movieName;
        nameView.setText(movie.name + "\n"+ movie.year);

        LinearLayout movieList = holder.movieListFrag;
        movieList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MoviesPage.class);
                intent.putExtra("name", movie.name);
                intent.putExtra("year", movie.year);
                intent.putExtra("description", movie.description);
                intent.putExtra("director", movie.director);
                intent.putExtra("stars", movie.stars);
                intent.putExtra("imdbRating", movie.imdbRating);
                intent.putExtra("RTrating", movie.RTrating);
                intent.putExtra("genre", movie.genre);
                intent.putExtra("link", movie.imdbLink);
                intent.putExtra("imgLink",movie.imageLink);
                intent.putExtra("link720p",movie.link720p);
                intent.putExtra("link1080p",movie.link1080p);

//                Bitmap bitmap = movie.bitmap;
//                ByteArrayOutputStream bs = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
//                intent.putExtra("image", bs.toByteArray());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}