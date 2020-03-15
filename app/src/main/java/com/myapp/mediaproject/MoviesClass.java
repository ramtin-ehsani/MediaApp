package com.myapp.mediaproject;

import android.widget.ImageView;

public class MoviesClass
{
    public String name, year, description, genre,
            director, stars, imdbRating, RTrating, imdbLink, link720, link1080p;
    public ImageView poster;

    MoviesClass(String name, String year, String description,
           String director, String stars, String imdbRating,
           String RTrating, ImageView poster, String genre,
                String imdbLink, String link720, String link1080p)
    {
        this.genre = genre;
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.stars = stars;
        this.imdbRating = imdbRating;
        this.RTrating = RTrating;
        this.poster = poster;
        this.imdbLink = imdbLink;
        this.link720 = link720;
        this.link1080p = link1080p;
    }
}
