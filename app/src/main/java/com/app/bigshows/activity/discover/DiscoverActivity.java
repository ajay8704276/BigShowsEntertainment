package com.app.bigshows.activity.discover;

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
import com.app.bigshows.adapters.discover.DiscoverViewPagerAdapter;
import com.app.bigshows.fragments.discover.Discover_Movies;
import com.app.bigshows.fragments.discover.Discover_TVShows;
import com.app.bigshows.utils.Constants;


/**
 * Created by Ajay Kumar on 7/8/2016.
 */

public class DiscoverActivity extends AppCompatActivity {

    private Toolbar discoverToolbar;
    private TabLayout discoverTabLayout;
    private ViewPager discoverViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.discover);


        discoverToolbar = (Toolbar) findViewById(R.id.discover_toolbar);
        setSupportActionBar(discoverToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        discoverViewPager = (ViewPager) findViewById(R.id.viewpager_discover);
        setupViewPager(discoverViewPager);

        discoverTabLayout = (TabLayout) findViewById(R.id.tab_discover);
        discoverTabLayout.setupWithViewPager(discoverViewPager);
        setupTabIcon();

    }

    @Override
    protected void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_DISCOVER);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.discover_menu, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    private void setupTabIcon() {

        discoverTabLayout.getTabAt(0).setIcon(android.R.drawable.ic_dialog_info);
        discoverTabLayout.getTabAt(1).setIcon(android.R.drawable.ic_dialog_alert);
    }

    private void setupViewPager(ViewPager movieViewPager) {

        DiscoverViewPagerAdapter mDiscoverViewPagerAdapter = new DiscoverViewPagerAdapter(getSupportFragmentManager());
        mDiscoverViewPagerAdapter.addFragment(new Discover_Movies(),"MOVIES");
        mDiscoverViewPagerAdapter.addFragment(new Discover_TVShows(),"TV SHOWS");

        movieViewPager.setAdapter(mDiscoverViewPagerAdapter);
    }
}
