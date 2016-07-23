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

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.adapters.homepage.ontheair.AiringTodayDetailActivityAdapter;
import com.app.bigshows.adapters.search.SearchAdapter;
import com.app.bigshows.fragments.home.airing_today.AiringToday_Credits;
import com.app.bigshows.fragments.home.airing_today.AiringToday_Details;
import com.app.bigshows.fragments.home.airing_today.AiringToday_Similars;
import com.app.bigshows.model.search.Search;
import com.app.bigshows.model.search.SearchWrapper;
import com.app.bigshows.rest.ApiClient;
import com.app.bigshows.rest.search.SearchApiInterface;
import com.app.bigshows.utils.Constants;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

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
    private InterstitialAd mInterstitialAd;

    private RecyclerView mSearchRecyclerView;
    private MaterialSearchView materialSearchView;

    @Override
    public void onBackPressed() {
        if(materialSearchView.isSearchOpen()){
            materialSearchView.closeSearch();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent().getExtras()!=null){
            tvShowID = getIntent().getExtras().getInt("TV_SHOW_ID");
        }
        setContentView(R.layout.home_airing_today_details);



       /* mSearchRecyclerView = (RecyclerView) findViewById(R.id.search_rv);
        mSearchRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));*/
        materialSearchView = (MaterialSearchView) findViewById(R.id.material_search_view);
       // materialSearchView.addView(mSearchRecyclerView);





        //Loading Interstitial Ad
        mInterstitialAd = new InterstitialAd(this);
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
        });


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
        materialSearchView.setMenuItem(item);
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText!=null && newText.length()>0) {
                    //Create request
                    SearchApiInterface mSearchApiInterface = ApiClient.getRetrofitInstance().create(SearchApiInterface.class);
                    Call<Search> mCallSearch = mSearchApiInterface.getSearchResults(Constants.API_KEY, newText);
                    mCallSearch.enqueue(new Callback<Search>() {
                        @Override
                        public void onResponse(Call<Search> call, Response<Search> response) {

                            final List<SearchWrapper> mSearchWrappers = response.body().getResults();
                            final ArrayList<String> mSearchResultString = new ArrayList<String>();

                           /* for (int i = 0; i < mSearchWrappers.size(); i++) {
                                mSearchResultString.add(mSearchWrappers.get(i).getName());
                            }*/

                            SearchAdapter mSearchAdapter = new SearchAdapter(mSearchWrappers, R.layout.search_card_view, getApplicationContext());
                            if (mSearchAdapter != null) {
                                // mSearchAdapter.notify();
                                mSearchRecyclerView.setVisibility(View.VISIBLE);
                            }
                            mSearchRecyclerView.setAdapter(mSearchAdapter);

                        }

                        @Override
                        public void onFailure(Call<Search> call, Throwable t) {

                        }
                    });
                }else {
                    mSearchRecyclerView.setVisibility(View.GONE);
                }
                return true;
            }
        });
        /*final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));*/
/*
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {



                if(newText!=null && newText.length()>0) {
                    //Create request
                    SearchApiInterface mSearchApiInterface = ApiClient.getRetrofitInstance().create(SearchApiInterface.class);
                    Call<Search> mCallSearch = mSearchApiInterface.getSearchResults(Constants.API_KEY, newText);
                    mCallSearch.enqueue(new Callback<Search>() {
                        @Override
                        public void onResponse(Call<Search> call, Response<Search> response) {

                            final List<SearchWrapper> mSearchWrappers = response.body().getResults();
                            final ArrayList<String> mSearchResultString = new ArrayList<String>();

                           */
/* for (int i = 0; i < mSearchWrappers.size(); i++) {
                                mSearchResultString.add(mSearchWrappers.get(i).getName());
                            }*//*


                            SearchAdapter mSearchAdapter = new SearchAdapter(mSearchWrappers, R.layout.search_card_view, getApplicationContext());
                            if (mSearchAdapter != null) {
                               // mSearchAdapter.notify();
                                mSearchRecyclerView.setVisibility(View.VISIBLE);
                            }
                            mSearchRecyclerView.setAdapter(mSearchAdapter);

                        }

                        @Override
                        public void onFailure(Call<Search> call, Throwable t) {

                        }
                    });
                }else {
                    mSearchRecyclerView.setVisibility(View.GONE);
                }
                return true;
            }
        });
*/
        return true;
    }

    private void setupTabIcon() {

        airingTodayDetailTabLayout.getTabAt(0).setIcon(android.R.drawable.ic_dialog_email);
        airingTodayDetailTabLayout.getTabAt(1).setIcon(android.R.drawable.ic_dialog_dialer);
        airingTodayDetailTabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_info);
    }

    private void setupViewPager(ViewPager airingTodayDetailViewPager) {

        AiringTodayDetailActivityAdapter mAiringTodayDetailActivityAdapter = new AiringTodayDetailActivityAdapter(getSupportFragmentManager());
        mAiringTodayDetailActivityAdapter.addFragment(new AiringToday_Details(tvShowID),"DETAILS");
        mAiringTodayDetailActivityAdapter.addFragment(new AiringToday_Credits(tvShowID),"CREDITS");
        mAiringTodayDetailActivityAdapter.addFragment(new AiringToday_Similars(tvShowID),"SIMILAR");

        airingTodayDetailViewPager.setAdapter(mAiringTodayDetailActivityAdapter);
    }
}
