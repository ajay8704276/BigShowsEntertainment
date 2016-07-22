package com.app.bigshows.fragments.home.airing_today;

import android.os.Bundle;
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
import com.app.bigshows.adapters.homepage.AiringToday_Credits_castAdpater;
import com.app.bigshows.adapters.homepage.AiringToday_Credits_crewAdapter;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsCredits;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsCredits_CastWrapper;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsCredits_CrewWrapper;
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

public class AiringToday_Credits extends Fragment {

    private RecyclerView mCreditsCast;
    private RecyclerView mCreditsCrew;

    private AiringToday_Credits_castAdpater mAiringTodayCreditsCastAdpater;
    private AiringToday_Credits_crewAdapter mAiringTodayCreditsCrewAdapter;

    private int tvShowID;
    private View view;


    //Empty constructor required

    public AiringToday_Credits(int tvShowID){

        this.tvShowID = tvShowID;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


            view = inflater.inflate(R.layout.home_airing_today_credits,container,false);
            mCreditsCrew = (RecyclerView) view.findViewById(R.id.airing_today_credits_crewRV);
            mCreditsCrew.setLayoutManager(new LinearLayoutManager(getActivity()));

            mCreditsCast = (RecyclerView) view.findViewById(R.id.airing_today_credits_castRV);
            mCreditsCast.setLayoutManager(new LinearLayoutManager(getActivity()));


            //display progress dialog
            /*dialog = BigShowsGenericDialogHelper.builddefaultDialog(getContext(),"Please wait while we loading...",false ,true);
            dialog.show();*/

            ApiInterface mApiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
            Call<AiringTodayTVShowsCredits> call = mApiInterface.getAiringTodayTVShpwsCredits(tvShowID, Constants.API_KEY);
            call.enqueue(new Callback<AiringTodayTVShowsCredits>() {
                @Override
                public void onResponse(Call<AiringTodayTVShowsCredits> call, Response<AiringTodayTVShowsCredits> response) {

                    /*if(response.isSuccessful()){
                        //dismiss dialog
                        dialog.dismiss();
                    }*/


                    // initialise data model before using
                    if(response.isSuccessful()){
                        if(response.body()!=null){
                            final List<AiringTodayTVShowsCredits_CastWrapper> mAiringTodayTVShowsCredits_castWrappers = response.body().getCast();
                            final List<AiringTodayTVShowsCredits_CrewWrapper> mAiringTodayTVShowsCredits_crewWrappers = response.body().getCrew();

                            mAiringTodayCreditsCastAdpater = new AiringToday_Credits_castAdpater(mAiringTodayTVShowsCredits_castWrappers, R.layout.airing_today_credits_cast_cardview, getContext());
                            mCreditsCast.setAdapter(mAiringTodayCreditsCastAdpater);
                            mCreditsCast.hasFixedSize();

                            mAiringTodayCreditsCrewAdapter = new AiringToday_Credits_crewAdapter(mAiringTodayTVShowsCredits_crewWrappers, R.layout.airing_today_credits_crew_cardview, getContext());
                            mCreditsCrew.setAdapter(mAiringTodayCreditsCrewAdapter);
                            mCreditsCrew.hasFixedSize();

                        }
                    }

                }

                @Override
                public void onFailure(Call<AiringTodayTVShowsCredits> call, Throwable t) {

                   // dialog.dismiss();
                    Toast.makeText(getContext(), "error =" + t.toString(), Toast.LENGTH_LONG).show();

                }
            });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_AIRING_CREDITS);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
