package com.app.bigshows.activity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.app.bigshows.R;
import com.app.bigshows.adapters.homepage.intheater.NowPlayingAdapter;
import com.app.bigshows.adapters.homepage.intheater.NowPlayingDetailactivityAdapter;
import com.app.bigshows.fragments.home.in_theater.NowPlayingCredits;
import com.app.bigshows.fragments.home.in_theater.NowPlayingMovieDetail;
import com.app.bigshows.fragments.home.in_theater.NowPlayingTrailersorVideos;

/**
 * Created by Ajay Kumar on 7/22/2016.
 */

public class NowPlayingDetailActivity extends AppCompatActivity {

    private Toolbar nowPlayingDetailToolbar;
    private ViewPager nowPlayingDetailViewPager;
    private TabLayout nowPlayingDetailTabLayout;
    private int movieId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_now_playing_details);

        if (getIntent().getExtras()!=null){
            movieId = getIntent().getExtras().getInt(NowPlayingAdapter.MOVIEID);
        }

        nowPlayingDetailToolbar = (Toolbar) findViewById(R.id.home_nowplaying_detail_toolbar);
        setSupportActionBar(nowPlayingDetailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nowPlayingDetailViewPager = (ViewPager) findViewById(R.id.viewpager_home_nowplaying_detail);
        setupViewPager(nowPlayingDetailViewPager);

        nowPlayingDetailTabLayout = (TabLayout) findViewById(R.id.tab_home_nowplaying_detail);
        nowPlayingDetailTabLayout.setupWithViewPager(nowPlayingDetailViewPager);
        setupTabIcon();
    }

    private void setupViewPager(ViewPager nowPlayingDetailViewPager) {

        NowPlayingDetailactivityAdapter mNowPlayingDetailactivityAdapter = new NowPlayingDetailactivityAdapter(getSupportFragmentManager());
        mNowPlayingDetailactivityAdapter.addFragment(NowPlayingMovieDetail.getInstance(movieId), "DETAILS");
        mNowPlayingDetailactivityAdapter.addFragment(NowPlayingCredits.getInstance(movieId), "CREDITS");
        mNowPlayingDetailactivityAdapter.addFragment(NowPlayingTrailersorVideos.getInstance(movieId), "TRAILERS");

        nowPlayingDetailViewPager.setAdapter(mNowPlayingDetailactivityAdapter);

    }

    private void setupTabIcon() {

        nowPlayingDetailTabLayout.getTabAt(0).setIcon(android.R.drawable.ic_dialog_email);
        nowPlayingDetailTabLayout.getTabAt(1).setIcon(android.R.drawable.ic_dialog_dialer);
        nowPlayingDetailTabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_info);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
