package com.app.bigshows.activity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.adapters.homepage.ontheair.AiringTodayDetailActivityAdapter;
import com.app.bigshows.adapters.homepage.ontheair.OnTheAirResultAdapter;
import com.app.bigshows.adapters.search.SearchAdapter;
import com.app.bigshows.fragments.home.airing_today.AiringToday_Credits;
import com.app.bigshows.fragments.home.airing_today.AiringToday_Details;
import com.app.bigshows.fragments.home.airing_today.AiringToday_Similars;
import com.app.bigshows.model.search.Search;
import com.app.bigshows.model.search.SearchWrapper;
import com.app.bigshows.rest.ApiClient;
import com.app.bigshows.rest.search.SearchApiInterface;
import com.app.bigshows.utils.Constants;
import com.app.bigshows.utils.ViewPagerAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

public class AiringTodayDetailActivity extends AppCompatActivity {


    private Toolbar airingTodayDetailToolbar;
    private TabLayout airingTodayDetailTabLayout;
    private ViewPager airingTodayDetailViewPager;
    private int tvShowID;
    private String posterPath;
    private Toolbar mToolbar;
    private String mTVShowTitle;
    private InterstitialAd mInterstitialAd;

    private RecyclerView mSearchRecyclerView;

    /*private ViewPager mPosterImageViewPager;
    private ViewPagerAdapter mPosterViewPagerAdapter;*/
    private ImageView mPosterIV;
    ImageLoader imageLoader;
    DisplayImageOptions options;

    @Override
    public void onBackPressed() {

            super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent().getExtras()!=null){
            tvShowID = getIntent().getExtras().getInt("TV_SHOW_ID");
            posterPath = getIntent().getExtras().getString(OnTheAirResultAdapter.TV_SHOW_POSTER_PATH);
            mTVShowTitle = getIntent().getExtras().getString(OnTheAirResultAdapter.TV_SHOW_TITLE);
        }
        setContentView(R.layout.home_airing_today_details);

        mToolbar = (Toolbar) findViewById(R.id.home_airing_today_detail_toolbar);
        mToolbar.setTitle(mTVShowTitle);

        mPosterIV = (ImageView) findViewById(R.id.home_airing_today_IV);
        imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageOnLoading(R.drawable.image_progress_anim)
                .showImageForEmptyUri(R.drawable.broken_image)
                .showImageOnFail(R.drawable.broken_image)
                .build();


        mPosterIV = (ImageView) findViewById(R.id.home_airing_today_IV);
        imageLoader.displayImage(Constants.IMAGE_PATH +posterPath,mPosterIV,options);


       /* mPosterImageViewPager = (ViewPager) findViewById(R.id.home_airing_today_viewpager);
        mPosterViewPagerAdapter = new ViewPagerAdapter(this,posterPath);
        mPosterImageViewPager.setAdapter(mPosterViewPagerAdapter);
*/

       /* mSearchRecyclerView = (RecyclerView) findViewById(R.id.search_rv);
        mSearchRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));*/
       // materialSearchView.addView(mSearchRecyclerView);





        //Loading Interstitial Ad
       /* mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitials_home));
        AdRequest mInterstitialsAdRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(mInterstitialsAdRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                showInterstitials();

            }
        });*/


        airingTodayDetailToolbar = (Toolbar) findViewById(R.id.home_airing_today_detail_toolbar);
        setSupportActionBar(airingTodayDetailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        airingTodayDetailViewPager = (ViewPager) findViewById(R.id.viewpager_home_airing_today_detail);
        setupViewPager(airingTodayDetailViewPager);

        airingTodayDetailTabLayout = (TabLayout) findViewById(R.id.tab_home_airing_today_detail);
        airingTodayDetailTabLayout.setupWithViewPager(airingTodayDetailViewPager);
        setupTabIcon();

    }

    private void showInterstitials() {

        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_AIRING);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.movies_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        return true;
    }

    private void setupTabIcon() {

        airingTodayDetailTabLayout.getTabAt(0).setIcon(android.R.drawable.ic_dialog_email);
        airingTodayDetailTabLayout.getTabAt(1).setIcon(android.R.drawable.ic_dialog_dialer);
        airingTodayDetailTabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_info);
    }

    private void setupViewPager(ViewPager airingTodayDetailViewPager) {

        AiringTodayDetailActivityAdapter mAiringTodayDetailActivityAdapter = new AiringTodayDetailActivityAdapter(getSupportFragmentManager());
        mAiringTodayDetailActivityAdapter.addFragment(AiringToday_Details.getInstance(tvShowID),"DETAILS");
        mAiringTodayDetailActivityAdapter.addFragment(AiringToday_Credits.getInstance(tvShowID),"CREDITS");
        mAiringTodayDetailActivityAdapter.addFragment(AiringToday_Similars.getInstance(tvShowID),"SIMILAR");
        airingTodayDetailViewPager.setAdapter(mAiringTodayDetailActivityAdapter);
    }

}
