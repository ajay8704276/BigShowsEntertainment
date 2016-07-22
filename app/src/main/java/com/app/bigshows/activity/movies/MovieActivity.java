package com.app.bigshows.activity.movies;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.adapters.movies.MovieViewPagerAdapter;
import com.app.bigshows.fragments.movies.Movie_TopRated;
import com.app.bigshows.fragments.movies.Movies_NowPlaying;
import com.app.bigshows.fragments.movies.Movies_Popular;
import com.app.bigshows.fragments.movies.Movies_Upcoming;
import com.app.bigshows.utils.Constants;

/**
 * Created by Ajay Kumar on 7/8/2016.
 */

public class MovieActivity extends AppCompatActivity {


    private Toolbar movieToolbar;
    private TabLayout movieTabLayout;
    private ViewPager movieViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.movies);


        movieToolbar = (Toolbar) findViewById(R.id.movie_toolbar);
        setSupportActionBar(movieToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        movieViewPager = (ViewPager) findViewById(R.id.viewpager_movie);
        setupViewPager(movieViewPager);

        movieTabLayout = (TabLayout) findViewById(R.id.tab_movie);
        movieTabLayout.setupWithViewPager(movieViewPager);
        setupTabIcon();

    }

    @Override
    protected void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_MOVIE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.movies_menu, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    private void setupTabIcon() {

        movieTabLayout.getTabAt(0).setIcon(android.R.drawable.ic_dialog_email);
        movieTabLayout.getTabAt(1).setIcon(android.R.drawable.ic_dialog_dialer);
        movieTabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_info);
        movieTabLayout.getTabAt(3).setIcon(android.R.drawable.ic_dialog_map);
    }

    private void setupViewPager(ViewPager movieViewPager) {

        MovieViewPagerAdapter mMovieViewPagerAdapter = new MovieViewPagerAdapter(getSupportFragmentManager());
        mMovieViewPagerAdapter.addFragment(new Movie_TopRated(),"TOP RATED");
        mMovieViewPagerAdapter.addFragment(new Movies_NowPlaying(),"NOW PLAYING");
        mMovieViewPagerAdapter.addFragment(new Movies_Popular(),"POPULAR");
        mMovieViewPagerAdapter.addFragment(new Movies_Upcoming(),"UPCOMING");

        movieViewPager.setAdapter(mMovieViewPagerAdapter);
    }
}
