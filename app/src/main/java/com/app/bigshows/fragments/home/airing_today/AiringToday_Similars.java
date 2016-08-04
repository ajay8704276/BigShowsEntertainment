package com.app.bigshows.fragments.home.airing_today;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bigshows.BigShowsEntertainmentApp;
import com.app.bigshows.R;
import com.app.bigshows.adapters.homepage.ontheair.AiringToday_Similar_TVShowsAdapter;
import com.app.bigshows.adapters.homepage.ontheair.AiringToday_Similar_TVVideosAdapter;
import com.app.bigshows.model.home.tvshows.AirinTodayTVShowsSimilar_TVVideos;
import com.app.bigshows.model.home.tvshows.AirinTodayTVShowsSimilar_TVVideos_ResultWrapper;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsSimilar_TVShows;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsSimilar_TVShows_ResultWrapper;
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

public class AiringToday_Similars  extends Fragment{

    private RecyclerView mTVShowsRecyclerView;
    private RecyclerView mTVVideosRecyclerView;

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private AiringTodayTVShowsSimilar_TVShows_ResultWrapper airingTodayTVShowsSimilar_tvShows_resultWrapper;
    private AirinTodayTVShowsSimilar_TVVideos_ResultWrapper airinTodayTVShowsSimilar_tvVideos_resultWrapper;

    private static int tvShowID;

    private View view;

    private ProgressDialog dialog;


    //Empty constructor required

    public AiringToday_Similars(){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



            view = inflater.inflate(R.layout.home_airing_today_similar,container,false);
            mTVShowsRecyclerView = (RecyclerView) view.findViewById(R.id.airing_today_similar_similarTVShowsRV);
            mTVShowsRecyclerView.hasFixedSize();

            // Setting Staggered view
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
            //mTVShowsRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
            mTVShowsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


            // Setting Horizontle view
            mTVVideosRecyclerView = (RecyclerView) view.findViewById(R.id.airing_today_similar_similarvideosRV);
            mTVVideosRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            mTVVideosRecyclerView.hasFixedSize();

            //display progress dialog
            /*dialog = BigShowsGenericDialogHelper.builddefaultDialog(getContext(),"Please wait while we loading...",false ,true);
            dialog.show();*/


            // Interface for similar tv shows
            ApiInterface mApiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
            Call<AiringTodayTVShowsSimilar_TVShows> call = mApiInterface.getAiringTodayTVShowsSimilar(tvShowID, Constants.API_KEY);
            call.enqueue(new Callback<AiringTodayTVShowsSimilar_TVShows>() {
                @Override
                public void onResponse(Call<AiringTodayTVShowsSimilar_TVShows> call, Response<AiringTodayTVShowsSimilar_TVShows> response) {


                    /*if(response.isSuccessful()){
                        //dismiss dialog
                        dialog.dismiss();
                    }*/


                    // initialise POJO before Using
                    if(response.isSuccessful()) {

                        if(response.body()!=null) {
                            final List<AiringTodayTVShowsSimilar_TVShows_ResultWrapper> airingTodayTVShowsSimilar_tvShows_resultWrappers = response.body().getResults();
                            AiringToday_Similar_TVShowsAdapter airingToday_similar_tvShowsAdapter = new AiringToday_Similar_TVShowsAdapter(airingTodayTVShowsSimilar_tvShows_resultWrappers, R.layout.airing_today_similar_similartvshows_cardview, getContext());
                            mTVShowsRecyclerView.setAdapter(airingToday_similar_tvShowsAdapter);
                        }
                    }
                }

                @Override
                public void onFailure(Call<AiringTodayTVShowsSimilar_TVShows> call, Throwable t) {

                    //dialog.dismiss();
                   // Toast.makeText(getContext(), "response =" + t.getCause().toString(), Toast.LENGTH_LONG).show();
                }
            });


            ApiInterface tvVideosInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
            Call<AirinTodayTVShowsSimilar_TVVideos> airinTodayTVShowsSimilar_tvVideosCall = tvVideosInterface.getAiringTodayTVShowsSimilarTVVideos(tvShowID, Constants.API_KEY);
            airinTodayTVShowsSimilar_tvVideosCall.enqueue(new Callback<AirinTodayTVShowsSimilar_TVVideos>() {
                @Override
                public void onResponse(Call<AirinTodayTVShowsSimilar_TVVideos> call, Response<AirinTodayTVShowsSimilar_TVVideos> response) {

                    //dismiss dialog
                    //dialog.dismiss();


                    //initialise POJO before using
                    if(response.isSuccessful()){

                        if(response.body()!=null){
                            final List<AirinTodayTVShowsSimilar_TVVideos_ResultWrapper> airinTodayTVShowsSimilar_tvVideos_resultWrappers = response.body().getResults();
                            AiringToday_Similar_TVVideosAdapter airingToday_similar_tvVideosAdapter = new AiringToday_Similar_TVVideosAdapter(airinTodayTVShowsSimilar_tvVideos_resultWrappers, R.layout.airing_today_similar_similartvvideos_cardview, getContext());
                            mTVVideosRecyclerView.setAdapter(airingToday_similar_tvVideosAdapter);
                        }
                    }


                }

                @Override
                public void onFailure(Call<AirinTodayTVShowsSimilar_TVVideos> call, Throwable t) {

                    //Toast.makeText(getContext(), "response =" + t.getCause().toString(), Toast.LENGTH_LONG).show();

                }
            });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_AIRING_SIMILAR);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public  static AiringToday_Similars getInstance(int mTVShowID){

        AiringToday_Similars mAiringTodaySimilars = new AiringToday_Similars();
        tvShowID = mTVShowID;
        return mAiringTodaySimilars;
    }
}
