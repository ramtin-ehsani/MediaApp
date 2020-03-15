package com.myapp.mediaproject;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.myapp.mediaproject.adapters.RVAdapterSeries;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends Fragment {
    RecyclerView recyclerView;

    public SeriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        recyclerView = view.findViewById(R.id.rvSeries);
        initSeries();

        return view;
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


        RVAdapterSeries adapter = new RVAdapterSeries(series, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
