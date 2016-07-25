package com.app.bigshows.fragments.home.in_theater;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.bigshows.R;
import com.app.bigshows.adapters.homepage.intheater.NowPlayingCreditsCastAdapter;
import com.app.bigshows.adapters.homepage.intheater.NowPlayingCreditsCrewAdapter;
import com.app.bigshows.model.home.intheater.NowPlayingCreditsModel;
import com.app.bigshows.rest.ApiClient;
import com.app.bigshows.rest.home.NowPlayingApiInterface;
import com.app.bigshows.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay Kumar on 7/22/2016.
 */

public class NowPlayingCredits extends Fragment {

    private static NowPlayingCredits mNowPlayingCredits;
    private int movieId;
    private RecyclerView mNowPlayingCastRV;
    private RecyclerView mNowPlayingCrewRV;
    private View view;


    private NowPlayingCredits(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.now_playing_credits, container, false);
            initViews(view);
            return view;
        }
        return view;
    }

    private void initViews(View view) {

        mNowPlayingCastRV = (RecyclerView) view.findViewById(R.id.now_playing_cast_rv);
        mNowPlayingCastRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mNowPlayingCastRV.hasFixedSize();

        mNowPlayingCrewRV = (RecyclerView) view.findViewById(R.id.now_playing_crew_rv);
        mNowPlayingCrewRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mNowPlayingCrewRV.hasFixedSize();


        startServerRequest();

    }

    private void startServerRequest() {

        NowPlayingApiInterface mNowPlayingApiInterface = ApiClient.getRetrofitInstance().create(NowPlayingApiInterface.class);
        Call<NowPlayingCreditsModel> mNowPlayingCreditsModelCall = mNowPlayingApiInterface.getNowPLayingCredits(movieId, Constants.API_KEY);
        mNowPlayingCreditsModelCall.enqueue(new Callback<NowPlayingCreditsModel>() {
            @Override
            public void onResponse(Call<NowPlayingCreditsModel> call, Response<NowPlayingCreditsModel> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        final List<NowPlayingCreditsModel.Cast> cast = response.body().getCast();
                        NowPlayingCreditsCastAdapter mCastAdapter = new NowPlayingCreditsCastAdapter(cast, getContext());
                        mNowPlayingCastRV.setAdapter(mCastAdapter);

                        final List<NowPlayingCreditsModel.Crew> crew = response.body().getCrew();
                        NowPlayingCreditsCrewAdapter mCrewAdapter = new NowPlayingCreditsCrewAdapter(crew, getContext());
                        mNowPlayingCrewRV.setAdapter(mCrewAdapter);

                    }
                } else {
                    Toast.makeText(getContext(), response.message().toString(), Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<NowPlayingCreditsModel> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    public static NowPlayingCredits getInstance(int movieId) {

        // if(mNowPlayingCredits == null){
        mNowPlayingCredits = new NowPlayingCredits(movieId);
        return mNowPlayingCredits;
        //}
        //return mNowPlayingCredits;
    }

}
