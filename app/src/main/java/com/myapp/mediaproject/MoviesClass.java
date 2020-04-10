package com.myapp.mediaproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.URL;

public class MoviesClass
{
    public String name, year, description, genre,
            director, stars, imdbRating, RTrating, imdbLink, imageLink, link720p, link1080p;
    public ImageView poster;
    public Bitmap bitmap;

    MoviesClass(String name, String year, String description,
                String director, String stars, String imdbRating,
                String RTrating, ImageView poster, String genre,
                String imdbLink, String link720p, String link1080p
                ,String imageLink)
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
        this.link720p = link720p;
        this.link1080p = link1080p;
        this.imageLink = imageLink;

        DownloadImage imagedownloader = new DownloadImage(imageLink);
        imagedownloader.start();
    }

    public class DownloadImage extends Thread {
        String url;

        DownloadImage(String string)
        {
            url = string;
        }

        public void run() {
            bitmap = null;

            try {
                bitmap = BitmapFactory.decodeStream(new URL(url).openStream());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            poster.setImageBitmap(bitmap);
            poster.setTag(poster.getDrawable());
        }
    }
}
