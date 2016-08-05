package com.app.bigshows.fragments.home.airing_today;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.adapters.homepage.ontheair.OnTheAirResultAdapter;
import com.app.bigshows.model.home.tvshows.OnTheAir;
import com.app.bigshows.model.home.tvshows.OnTheAir_Results;
import com.app.bigshows.rest.ApiClient;
import com.app.bigshows.rest.home.ApiInterface;
import com.app.bigshows.utils.BigShowsGenericDialogHelper;
import com.app.bigshows.utils.Constants;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay Kumar on 7/9/2016.
 */

public class Home_AiringToday  extends Fragment {

    public static final int PAGE_SIZE = 30;
    private boolean isLastPage = false;
    private int currentPage = 1;
    private boolean mIsLoading = false;



    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private OnTheAirResultAdapter mAirResultAdapter;
    private View view;
    ProgressDialog dialogHelper;
    private AdView mBannerAdview;


    // Empty constructor required
    public Home_AiringToday(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


            view = inflater.inflate(R.layout.home_airing_today, container, false);

            //banner adview
            String android_id = Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
            String deviceId = md5(android_id).toUpperCase();
            mBannerAdview = (AdView) view.findViewById(R.id.big_shows_home_banner_adview);
            AdRequest mBannerAdRequest = new AdRequest.Builder()
                    .addTestDevice(deviceId)
                    .build();
            mBannerAdview.loadAd(mBannerAdRequest);
            mBannerAdview.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                }

                @Override
                public void onAdFailedToLoad(int i) {

                    if(i == 0){
                        Toast.makeText(getContext(),"Internal Error occur" ,Toast.LENGTH_LONG).show();
                    }else if( i ==1){
                        Toast.makeText(getContext(),"INvalid request",Toast.LENGTH_LONG).show();
                    }else if( i == 2){
                        Toast.makeText(getContext(),"Network Error occur" ,Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getContext(),"inventory Eror occur" ,Toast.LENGTH_LONG).show();
                    }
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
                    //super.onAdLoaded();
                    Toast.makeText(getContext(),"On Ad Loaded ",Toast.LENGTH_LONG).show();
                }
            });


            mRecyclerView = (RecyclerView) view.findViewById(R.id.home_on_the_air_recycler_view);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


            dialogHelper = BigShowsGenericDialogHelper.builddefaultDialog(getContext(),"please wait while loading",false,true);
            dialogHelper.show();

            ApiInterface apiService = ApiClient.getRetrofitInstance().create(ApiInterface.class);
            Call<OnTheAir> call = apiService.getOnTheAirTVShows(Constants.API_KEY);

            call.enqueue(new Callback<OnTheAir>() {

                @Override
                public void onResponse(Call<OnTheAir> call, final Response<OnTheAir> response) {
                    if(response.isSuccessful()) {
                        dialogHelper.dismiss();
                        if(response.body()!=null){
                            final List<OnTheAir_Results> onTheAirResults = response.body().getResults();
                            mAirResultAdapter = new OnTheAirResultAdapter(onTheAirResults, R.layout.material_airing_tvshows_card, getContext());
                            mRecyclerView.setAdapter(mAirResultAdapter);
                            mRecyclerView.hasFixedSize();
                        }

                    }
                }

                @Override
                public void onFailure(Call<OnTheAir> call, Throwable t) {
                    dialogHelper.dismiss();
                    Toast.makeText(getContext(), "error =" + t.toString(), Toast.LENGTH_LONG).show();

                }
            });

        return view;
    }

    private String md5(String android_id) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(android_id.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    @Override
    public void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_HOME_AIRING);
        if (mBannerAdview!=null){
            mBannerAdview.resume();
        }
    }
    @Override
    public void onPause() {
        if (mBannerAdview != null) {
            mBannerAdview.pause();
        }
        super.onPause();
    }


    @Override
    public void onDestroy() {
        if (mBannerAdview != null) {
            mBannerAdview.destroy();
        }
        super.onDestroy();
    }

}
