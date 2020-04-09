package com.myapp.mediaproject;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.myapp.mediaproject.adapters.RVAdapterMovies2;
import com.myapp.mediaproject.adapters.RVAdapterSeries2;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recMovies;
    private RecyclerView recSeries;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recMovies = view.findViewById(R.id.recMovies);
        recSeries = view.findViewById(R.id.recSeries);
        handle();

        return view;
    }

    void handle(){
        initMovies();
        initSeries();
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
                "http://dl2.ftk.pw/film/Inception.2010.1080p.BluRay.scOrp.Film2Movie_BiZ.mkv",
                "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(R.drawable.bohemianrhapsody);
        imageView2.setTag(R.drawable.bohemianrhapsody);
        movies.add(new MoviesClass("Bohemian Rhapsody", "(2018)", "The story of the legendary British rock band Queen and lead singer Freddie Mercury, leading up to their famous performance at Live Aid (1985).",
                "Bryan Singer", "Rami Malek\nLucy Boynton\nGwilym Lee",
                "8/10", "7.9/10",  imageView2, "Biography\nDrama\nMusic", "https://www.imdb.com/title/tt1727824/?ref_=nv_sr_srsg_0",
                "http://dl8.disdn.com/Movie/Foreign/1397/11/Bohemian.Rhapsody.2018.720p.MkvCage.mkv?20190304195535",
                "http://dl8.disdn.com/Movie/Foreign/1397/11/Bohemian.Rhapsody.2018.1080p.6CH.MkvCage.mkv?20190304195508",
                "https://m.media-amazon.com/images/M/MV5BMTA2NDc3Njg5NDVeQTJeQWpwZ15BbWU4MDc1NDcxNTUz._V1_UX182_CR0,0,182,268_AL_.jpg"));

        ImageView imageView3 = new ImageView(getContext());
        imageView3.setImageResource(R.drawable.el_camino);
        imageView3.setTag(R.drawable.el_camino);
        movies.add(new MoviesClass("El Camino: A Breaking Bad Movie", "(2019)", "Aaron Paul, best known for his role as drug dealer Jesse Pinkman in \"Breaking Bad,\" reprises his role in the follow-up film El Camino: A Breaking Bad MovieFirebase. Who else has he played?",
                "Vince Gilligan", "Aaron Paul\nJonathan Banks\nMatt Jones",
                "7.4/10", "9.1/10",  imageView3, "Action\nCrime\nDrama", "https://www.imdb.com/title/tt9243946/?ref_=nv_sr_srsg_0",
                "http://dl2.uploadmax.ir/Film/New-Server/2019/El.Camino.A.Breaking.Bad.Movie.2019.720p.WEB-DL.PAHE.Film2Media.mkv",
                "http://dl2.uploadmax.ir/Film/New-Server/2019/El.Camino.A.Breaking.Bad.Movie.2019.1080p.WEB-DL.x264.6CH-Pahe.Film2Media.mkv",
                "https://m.media-amazon.com/images/M/MV5BNjk4MzVlM2UtZGM0ZC00M2M1LThkMWEtZjUyN2U2ZTc0NmM5XkEyXkFqcGdeQXVyOTAzMTc2MjA@._V1_UY268_CR16,0,182,268_AL_.jpg"));

        movies.add(new MoviesClass("Inception", "(2010)", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                "Christopher Nolan", "Leonardo DiCaprio\nJoseph Gordon-Levitt\nEllen Page",
                "8.8/10", "8.7/10",  imageView, "Action\\nAdventure\\nSci-fi", "https://www.imdb.com/title/tt1375666/",
                "http://dl2.ftk.pw/film/Inception.2010.720p.BluRay.scOrp.Film2Movie_BiZ.mkv",
                "http://dl2.ftk.pw/film/Inception.2010.1080p.BluRay.scOrp.Film2Movie_BiZ.mkv",
                "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_UX182_CR0,0,182,268_AL_.jpg"));

        movies.add(new MoviesClass("Bohemian Rhapsody", "(2018)", "The story of the legendary British rock band Queen and lead singer Freddie Mercury, leading up to their famous performance at Live Aid (1985).",
                "Bryan Singer", "Rami Malek\nLucy Boynton\nGwilym Lee",
                "8/10", "7.9/10",  imageView2, "Biography\nDrama\nMusic", "https://www.imdb.com/title/tt1727824/?ref_=nv_sr_srsg_0",
                "http://dl8.disdn.com/Movie/Foreign/1397/11/Bohemian.Rhapsody.2018.720p.MkvCage.mkv?20190304195535",
                "http://dl8.disdn.com/Movie/Foreign/1397/11/Bohemian.Rhapsody.2018.1080p.6CH.MkvCage.mkv?20190304195508",
                "https://m.media-amazon.com/images/M/MV5BMTA2NDc3Njg5NDVeQTJeQWpwZ15BbWU4MDc1NDcxNTUz._V1_UX182_CR0,0,182,268_AL_.jpg"));


        RVAdapterMovies2 adapter = new RVAdapterMovies2(movies, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.ItemAnimator animator = new DefaultItemAnimator();
        recMovies.setItemAnimator(animator);
        recMovies.setAdapter(adapter);
        recMovies.setLayoutManager(layoutManager);

    }

    void initSeries()
    {
        List<SeriesClass> series = new ArrayList<>();

        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.breakingbad);
        imageView.setTag(R.drawable.breakingbad);
        series.add(new SeriesClass("Breaking Bad", "(2008)", "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.",
                "Vince Gilligan", "Bryan Cranston\nAaron Paul\nAnna Gunn",
                "9.5", "9.5",  imageView, "drama", "https://www.imdb.com/title/tt0903747/?ref_=nv_sr_srsg_0", 5));

        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(R.drawable.chernobyl);
        imageView2.setTag(R.drawable.chernobyl);
        series.add(new SeriesClass("Chernobyl", "(2019)", "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.",
                "Craig Mazin", "Jessie Buckley\nJared Harris\nStellan Skarsgård",
                "9.4", "8.8",  imageView2, "history", "https://www.imdb.com/title/tt0944947/?ref_=nv_sr_srsg_0", 1));


        ImageView imageView3 = new ImageView(getContext());
        imageView3.setImageResource(R.drawable.got);
        imageView3.setTag(R.drawable.got);
        series.add(new SeriesClass("Game Of Thrones", "(2011)", "Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.",
                "David Benioff\nD.B. Weiss", "Emilia Clarke\nPeter Dinklage\nKit Harington",
                "9.3", "8.0",  imageView3, "history\n sci-fi\ndrama", "https://www.imdb.com/title/tt7366338/?ref_=fn_al_tt_1", 8));

        series.add(new SeriesClass("Breaking Bad", "(2008)", "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.",
                "Vince Gilligan", "Bryan Cranston\nAaron Paul\nAnna Gunn",
                "9.5", "9.5",  imageView, "drama", "https://www.imdb.com/title/tt0903747/?ref_=nv_sr_srsg_0", 5));

        series.add(new SeriesClass("Chernobyl", "(2019)", "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.",
                "Craig Mazin", "Jessie Buckley\nJared Harris\nStellan Skarsgård",
                "9.4", "8.8",  imageView2, "history", "https://www.imdb.com/title/tt0944947/?ref_=nv_sr_srsg_0", 1));


        RVAdapterSeries2 adapter = new RVAdapterSeries2(series, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.ItemAnimator animator = new DefaultItemAnimator();
        recMovies.setItemAnimator(animator);
        recSeries.setAdapter(adapter);
        recSeries.setLayoutManager(layoutManager);

    }

}
