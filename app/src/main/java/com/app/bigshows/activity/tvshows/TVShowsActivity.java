package com.app.bigshows.activity.tvshows;

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
import com.app.bigshows.adapters.tvshows.TVShowsViewPagerAdapter;
import com.app.bigshows.fragments.tvshows.TVShows_AiringToday;
import com.app.bigshows.fragments.tvshows.TVShows_OnTV;
import com.app.bigshows.fragments.tvshows.TVShows_Popular;
import com.app.bigshows.fragments.tvshows.TVShows_TopRated;
import com.app.bigshows.utils.Constants;

/**
 * Created by Ajay Kumar on 7/8/2016.
 */

public class TVShowsActivity extends AppCompatActivity {


    private Toolbar tvShowsToolbar;
    private TabLayout tvShowsTabLayout;
    private ViewPager tvShowsViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.movies);


        tvShowsToolbar = (Toolbar) findViewById(R.id.movie_toolbar);
        setSupportActionBar(tvShowsToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvShowsViewPager = (ViewPager) findViewById(R.id.viewpager_movie);
        setupViewPager(tvShowsViewPager);

        tvShowsTabLayout = (TabLayout) findViewById(R.id.tab_movie);
        tvShowsTabLayout.setupWithViewPager(tvShowsViewPager);
        setupTabIcon();

    }

    @Override
    protected void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_TVSHOWS);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tvshows_menu, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    private void setupTabIcon() {

        tvShowsTabLayout.getTabAt(0).setIcon(android.R.drawable.ic_dialog_email);
        tvShowsTabLayout.getTabAt(1).setIcon(android.R.drawable.ic_dialog_dialer);
        tvShowsTabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_info);
        tvShowsTabLayout.getTabAt(3).setIcon(android.R.drawable.ic_dialog_map);
    }

    private void setupViewPager(ViewPager movieViewPager) {

        TVShowsViewPagerAdapter mTvShowsViewPagerAdapter = new TVShowsViewPagerAdapter(getSupportFragmentManager());
        mTvShowsViewPagerAdapter.addFragment(new TVShows_Popular(),"POPULAR");
        mTvShowsViewPagerAdapter.addFragment(new TVShows_TopRated(),"TOP RATED");
        mTvShowsViewPagerAdapter.addFragment(new TVShows_OnTV(),"ON TV");
        mTvShowsViewPagerAdapter.addFragment(new TVShows_AiringToday(),"AIRING TODAY");

        movieViewPager.setAdapter(mTvShowsViewPagerAdapter);
    }
}
