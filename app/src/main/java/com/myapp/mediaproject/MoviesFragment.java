package com.myapp.mediaproject;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.myapp.mediaproject.adapters.RVAdapterMovies;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    RecyclerView recyclerView;

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = view.findViewById(R.id.rvMovies);
        initMovies();

        return view;
    }

    void initMovies()
    {
        List<MoviesClass> movies = new ArrayList<>();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.inception);
        imageView.setTag(R.drawable.inception);
        movies.add(new MoviesClass("Inception", "(2010)", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                "Christopher Nolan", "Leonardo DiCaprio\nJoseph Gordon-Levitt\nEllen Page",
                "8.8/10", "8.7/10",  imageView, "Action\nAdventure\nSci-fi", "https://www.imdb.com/title/tt1375666/",
                "http://dl2.ftk.pw/film/Inception.2010.720p.BluRay.scOrp.Film2Movie_BiZ.mkv",
                "http://dl2.ftk.pw/film/Inception.2010.1080p.BluRay.scOrp.Film2Movie_BiZ.mkv"));

        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(R.drawable.bohemianrhapsody);
        imageView2.setTag(R.drawable.bohemianrhapsody);
        movies.add(new MoviesClass("Bohemian Rhapsody", "(2018)", "The story of the legendary British rock band Queen and lead singer Freddie Mercury, leading up to their famous performance at Live Aid (1985).",
                "Bryan Singer", "Rami Malek\nLucy Boynton\nGwilym Lee",
                "8/10", "7.9/10",  imageView2, "Biography\nDrama\nMusic", "https://www.imdb.com/title/tt1727824/?ref_=nv_sr_srsg_0",
                "http://dl8.disdn.com/Movie/Foreign/1397/11/Bohemian.Rhapsody.2018.720p.MkvCage.mkv?20190304195535",
                "http://dl8.disdn.com/Movie/Foreign/1397/11/Bohemian.Rhapsody.2018.1080p.6CH.MkvCage.mkv?20190304195508"));

        ImageView imageView3 = new ImageView(getContext());
        imageView3.setImageResource(R.drawable.el_camino);
        imageView3.setTag(R.drawable.el_camino);
        movies.add(new MoviesClass("El Camino: A Breaking Bad Movie", "(2019)", "Aaron Paul, best known for his role as drug dealer Jesse Pinkman in \"Breaking Bad,\" reprises his role in the follow-up film El Camino: A Breaking Bad Movie. Who else has he played?",
                "Vince Gilligan", "Aaron Paul\nJonathan Banks\nMatt Jones",
                "7.4/10", "9.1/10",  imageView3, "Action\nCrime\nDrama", "https://www.imdb.com/title/tt9243946/?ref_=nv_sr_srsg_0",
                "http://dl2.uploadmax.ir/Film/New-Server/2019/El.Camino.A.Breaking.Bad.Movie.2019.720p.WEB-DL.PAHE.Film2Media.mkv",
                "http://dl2.uploadmax.ir/Film/New-Server/2019/El.Camino.A.Breaking.Bad.Movie.2019.1080p.WEB-DL.x264.6CH-Pahe.Film2Media.mkv"));

        RVAdapterMovies adapter = new RVAdapterMovies(movies, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

}
