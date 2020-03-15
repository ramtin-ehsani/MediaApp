package com.myapp.mediaproject;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SeriesClass extends MoviesClass {

    public List<Boolean> seasons;

    SeriesClass(String name, String year, String description,
           String director, String stars, String imdbRating,
           String RTRating, ImageView poster, String genre,
                String imdbLink, int seasonsNo)
    {
        super(name, year, description, director, stars, imdbRating, RTRating, poster, genre, imdbLink,"","");

        seasons = new ArrayList<>();
        for (int i = 0; i < seasonsNo; i++)
            seasons.add(false);
    }
}
