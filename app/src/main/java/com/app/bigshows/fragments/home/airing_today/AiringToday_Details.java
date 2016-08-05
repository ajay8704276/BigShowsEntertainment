package com.app.bigshows.fragments.home.airing_today;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.adapters.homepage.ontheair.AiringToday_Details_SeasonsAdapter;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows_CreatedByWrapper;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows_GenreWrapper;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows_NetworkWrapper;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows_ProductionCompanyWrapper;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows_SeasonWrapper;
import com.app.bigshows.rest.ApiClient;
import com.app.bigshows.rest.home.ApiInterface;
import com.app.bigshows.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

public class AiringToday_Details extends Fragment {


    private RecyclerView mRecyclerView;
    private AiringToday_Details_SeasonsAdapter mAiringTodayDetailsSeasonsAdapter;
    private TextView mTVShowName;
    private TextView mTVShowYear;
    private TextView mTVShowOverView;
    private static int tvShowID;
    static AiringToday_Details mAiringTodayDetails;
    private View view;



    private List<AiringTodayTVShows_CreatedByWrapper> mAiringTodayTVShows_createdByWrappers;
    private List<AiringTodayTVShows_GenreWrapper> mAiringTodayTVShows_genreWrappers;
    private List<AiringTodayTVShows_NetworkWrapper> mAiringTodayTVShows_networkWrappers;
    private List<AiringTodayTVShows_ProductionCompanyWrapper> mAiringTodayTVShows_productionCompanyWrappers;
    private List<AiringTodayTVShows_SeasonWrapper> mAiringTodayTVShows_seasonWrappers;
    private AiringTodayTVShows mAiringTodayTVShows;

    //Empty constructor required

    public AiringToday_Details(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            view = inflater.inflate(R.layout.home_airing_today_info,container,false);
            mTVShowName = (TextView) view.findViewById(R.id.airing_today_details_show_name);
            mTVShowYear = (TextView) view.findViewById(R.id.airing_today_details_genre_year);
            mTVShowOverView = (TextView) view.findViewById(R.id.airing_today_details_overview);

            mRecyclerView = (RecyclerView) view.findViewById(R.id.airing_today_details_seasonrRV);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


            //display progress dialog
           /* dialog = BigShowsGenericDialogHelper.builddefaultDialog(getContext(),"Please wait while we loading...",false ,true);
            dialog.show();
*/
            ApiInterface apiService = ApiClient.getRetrofitInstance().create(ApiInterface.class);
            Call<AiringTodayTVShows> call = apiService.getAiringTodayTVShowsDetail(tvShowID, Constants.API_KEY);
            call.enqueue(new Callback<AiringTodayTVShows>() {
                @Override
                public void onResponse(Call<AiringTodayTVShows> call, Response<AiringTodayTVShows> response) {

                   /* if(response.isSuccessful()){
                        //dismiss dialog
                        dialog.dismiss();
                    }*/

                    //initialising all model classes
                    if (response.isSuccessful()) {
                        if (response.body() != null) {

                            mAiringTodayTVShows = response.body();
                            mAiringTodayTVShows_createdByWrappers = response.body().getCreatedBy();
                            mAiringTodayTVShows_genreWrappers = response.body().getGenres();
                            mAiringTodayTVShows_networkWrappers = response.body().getNetworks();
                            mAiringTodayTVShows_productionCompanyWrappers = response.body().getProductionCompanies();
                            mAiringTodayTVShows_seasonWrappers = response.body().getSeasons();


                            //set view
                            setView(response);

                            mAiringTodayDetailsSeasonsAdapter = new AiringToday_Details_SeasonsAdapter(mAiringTodayTVShows_seasonWrappers,mAiringTodayTVShows, R.layout.airing_today_details_season_cardview, getContext());
                            mRecyclerView.setAdapter(mAiringTodayDetailsSeasonsAdapter);
                            mRecyclerView.hasFixedSize();

                        }
                    }
                }

                private void setView(Response<AiringTodayTVShows> response) {

                    mTVShowName.setText(response.body().getOriginalName());
                    mTVShowYear.setText(response.body().getFirstAirDate());
                    mTVShowOverView.setText(response.body().getOverview());
                }

                @Override
                public void onFailure(Call<AiringTodayTVShows> call, Throwable t) {

                    /*dialog.dismiss();
                    Toast.makeText(getContext(), "error =" + t.toString(), Toast.LENGTH_LONG).show();*/
                }
            });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_AIRING_DETAILS);
    }

    public static AiringToday_Details getInstance(int mTVShowID){
        tvShowID = mTVShowID;
        if (mAiringTodayDetails== null){
            mAiringTodayDetails = new AiringToday_Details();
        }
        return mAiringTodayDetails;
    }

}
