package com.app.bigshows.fragments.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.utils.Constants;

/**
 * Created by Ajay Kumar on 7/8/2016.
 */

public class Movie_TopRated extends Fragment {

    @Override
    public void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_MOVIE_TOP_RATED);
    }

    // Empty constructor required
    public Movie_TopRated(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movies_toprated,container,false);
    }
}
