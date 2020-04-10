package com.myapp.mediaproject;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SeriesClass {

    public String name, year, description, genre,
            director, stars, imdbRating, RTrating, imdbLink;
    public ImageView poster;
    public List<Boolean> seasons;

    SeriesClass(String name, String year, String description,
           String director, String stars, String imdbRating,
           String RTrating, ImageView poster, String genre,
                String imdbLink, int seasonsNo)
    {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.stars = stars;
        this.imdbRating = imdbRating;
        this.RTrating = RTrating;
        this.poster = poster;
        this.genre = genre;
        this.imdbLink = imdbLink;
        seasons = new ArrayList<>();
        for (int i = 0; i < seasonsNo; i++)
            seasons.add(false);
    }
}
