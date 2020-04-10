package com.myapp.mediaproject;

public class MovieFirebase
{
    public String name, year, description, genre,
            director, stars, imdbRating, RTrating, imdbLink, imageLink, link720p, link1080p;
    MovieFirebase(String name, String year, String description,
                  String director, String stars, String imdbRating,
                  String RTrating, String genre,
                  String imdbLink, String link720p, String link1080p
            , String imageLink)
    {
        this.genre = genre;
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.stars = stars;
        this.imdbRating = imdbRating;
        this.RTrating = RTrating;
        this.imdbLink = imdbLink;
        this.link720p = link720p;
        this.link1080p = link1080p;
        this.imageLink = imageLink;

    }
    MovieFirebase(){

    }
}
