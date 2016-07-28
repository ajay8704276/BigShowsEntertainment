package com.app.bigshows.activity.home;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.activity.discover.DiscoverActivity;
import com.app.bigshows.activity.movies.MovieActivity;
import com.app.bigshows.activity.people.PeopleActivity;
import com.app.bigshows.activity.profile.ProfileActivity;
import com.app.bigshows.activity.tvshows.TVShowsActivity;
import com.app.bigshows.adapters.homepage.BigshowsHomepageAdapter;
import com.app.bigshows.fragments.home.airing_today.Home_AiringToday;
import com.app.bigshows.fragments.home.in_theater.Home_InTheater;
import com.app.bigshows.fragments.home.menu.Home_Menu;
import com.app.bigshows.fragments.home.upcoming.HomeUpcoming;
import com.app.bigshows.utils.Constants;
import com.google.android.gms.ads.AdView;

public class BigShowsHomeActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView mProfileImageView;
    private TextView mNavDiscoverShows;
    private TextView mNavMovies;
    private TextView mNavTvShows;
    private TextView mNavPeople;
    private TextView mNavSettings;
    private TextView mNavAbout;
    private TextView mUserProfileName;
    private TextView mUserName;

    private String profileName;
    private String userName;

    private TabLayout homeTabLayout;
    private ViewPager homeViewPager;

    private AdView mBannerAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getExtras() != null) {
            profileName = getIntent().getExtras().getString("ROFILE_NAME");
            userName = getIntent().getExtras().getString("USER_NAME");
        }

        /**
         * check user has valid session or not . If user doesnot have valid session
         *
         * create a valid session by authorising user detail by using userID and Password
         *
         * and get token stored in application class.
         *
         */

        setContentView(R.layout.activity_big_shows_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        homeViewPager = (ViewPager) findViewById(R.id.viewpager_home);
        setupViewPager(homeViewPager);

        homeTabLayout = (TabLayout) findViewById(R.id.home_tab);
        homeTabLayout.setupWithViewPager(homeViewPager);
        setupTabIcon();


        //home screen initialisation
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        /**
         *  -----------------------------------Nav Drawer Starts Here ------------------------------------------------------
         */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_big_shows_home);
        mUserProfileName = (TextView) headerView.findViewById(R.id.nav_user_profile_name);
        mUserName = (TextView) headerView.findViewById(R.id.nav_user_name);

        mUserProfileName.setText(profileName);
        mUserName.setText(userName);


        mProfileImageView = (ImageView) headerView.findViewById(R.id.nav_user_profile_image);
        mProfileImageView.setOnClickListener(this);


        mNavDiscoverShows = (TextView) headerView.findViewById(R.id.nav_discover_shows);
        mNavDiscoverShows.setOnClickListener(this);


        mNavMovies = (TextView) headerView.findViewById(R.id.nav_movies);
        mNavMovies.setOnClickListener(this);


        mNavTvShows = (TextView) headerView.findViewById(R.id.nav_tv_shows);
        mNavTvShows.setOnClickListener(this);


        mNavPeople = (TextView) headerView.findViewById(R.id.nav_people);
        mNavPeople.setOnClickListener(this);


        mNavSettings = (TextView) headerView.findViewById(R.id.nav_settings);
        mNavSettings.setOnClickListener(this);


        mNavAbout = (TextView) headerView.findViewById(R.id.nav_about);
        mNavAbout.setOnClickListener(this);

        /**
         * ---------------------------------------Nav Drawer ends Here ------------------------------------
         */

    }

    @Override
    protected void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_HOME);
        if(mBannerAdView!=null){
            mBannerAdView.resume();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.big_shows_home_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        //searchView.setMenuItem(item);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        if (BigShowsEntertainmentApp.getSingleInstance().isUserLoggedIN()) {
            MenuItemCompat.getActionView(menu.findItem(R.id.big_shows_home_menu_log_in)).setVisibility(View.GONE);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.action_search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        if (view == mNavDiscoverShows) {
            // do something
            //Snackbar.make(view , "Discover shows clicked",Snackbar.LENGTH_SHORT).show();

            Intent intent = new Intent(BigShowsHomeActivity.this, DiscoverActivity.class);
            startActivity(intent);

        } else if (view == mNavMovies) {
            // do something
            //Snackbar.make(view , "Movies shows clicked",Snackbar.LENGTH_SHORT).show();

            Intent intent = new Intent(BigShowsHomeActivity.this, MovieActivity.class);
            startActivity(intent);

        } else if (view == mNavTvShows) {
            // do something
            //Snackbar.make(view , "TV shows clicked",Snackbar.LENGTH_SHORT).show();

            Intent intent = new Intent(BigShowsHomeActivity.this, TVShowsActivity.class);
            startActivity(intent);

        } else if (view == mNavPeople) {
            // do something
            //Snackbar.make(view , "People shows clicked",Snackbar.LENGTH_SHORT).show();

            Intent intent = new Intent(BigShowsHomeActivity.this, PeopleActivity.class);
            startActivity(intent);

        } else if (view == mNavSettings) {
            //do something
            Snackbar.make(view, "Settings shows clicked", Snackbar.LENGTH_SHORT).show();

        } else if (view == mNavAbout) {
            // do something
            // Snackbar.make(view , "About shows clicked",Snackbar.LENGTH_SHORT).show();
            Intent intent = new Intent(BigShowsHomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        } else if (view == mProfileImageView) {

            // do something
            //Snackbar.make(view , "profile shows clicked",Snackbar.LENGTH_SHORT).show();

            Intent intent = new Intent(BigShowsHomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
    }


    private void setupTabIcon() {

        homeTabLayout.getTabAt(0).setIcon(android.R.drawable.ic_dialog_email);
        homeTabLayout.getTabAt(1).setIcon(android.R.drawable.ic_dialog_dialer);
        homeTabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_info);
        homeTabLayout.getTabAt(3).setIcon(android.R.drawable.ic_dialog_map);
    }

    private void setupViewPager(ViewPager homeViewPager) {

        BigshowsHomepageAdapter mBigshowsHomepageAdapter = new BigshowsHomepageAdapter(getSupportFragmentManager());
        mBigshowsHomepageAdapter.addFragment(new Home_AiringToday(), "AIRING");
        mBigshowsHomepageAdapter.addFragment(Home_InTheater.newInstance(), "IN THEATER");
        mBigshowsHomepageAdapter.addFragment(new HomeUpcoming(), "UPCOMING");
        mBigshowsHomepageAdapter.addFragment(new Home_Menu(), "MENU");

        homeViewPager.setAdapter(mBigshowsHomepageAdapter);
    }

    @Override
    public void onPause() {
        if (mBannerAdView != null) {
            mBannerAdView.pause();
        }
        super.onPause();
    }


    @Override
    public void onDestroy() {
        if (mBannerAdView != null) {
            mBannerAdView.destroy();
        }
        super.onDestroy();
    }

}
