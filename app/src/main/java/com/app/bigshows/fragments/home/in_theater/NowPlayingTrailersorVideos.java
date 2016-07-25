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
import com.app.bigshows.adapters.homepage.intheater.NowPlayingTrailersAdapter;
import com.app.bigshows.model.home.intheater.NowPlayingTrailers;
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

public class NowPlayingTrailersorVideos extends Fragment {

    private static NowPlayingTrailersorVideos mNowPlayingTrailersorVideos;
    private RecyclerView mTrailersRV;
    private int movieId;
    private View view;

    private NowPlayingTrailersorVideos(int movieId) {

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
            View view = inflater.inflate(R.layout.now_playing_trailers, container, false);

            initViews(view);

            return view;
        }
        return view;
    }


    private void initViews(View view) {

        mTrailersRV = (RecyclerView) view.findViewById(R.id.now_playing_trailersRV);
        mTrailersRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mTrailersRV.hasFixedSize();

        //start trailer server request
        NowPlayingApiInterface mNowPlayingApiInterface = ApiClient.getRetrofitInstance().create(NowPlayingApiInterface.class);
        Call<NowPlayingTrailers> mNowPlayingTrailersCall = mNowPlayingApiInterface.getNowPlayingTrailers(movieId, Constants.API_KEY);
        mNowPlayingTrailersCall.enqueue(new Callback<NowPlayingTrailers>() {
            @Override
            public void onResponse(Call<NowPlayingTrailers> call, Response<NowPlayingTrailers> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        List<NowPlayingTrailers.Result> results = response.body().getResults();
                        NowPlayingTrailersAdapter mNowPlayingTrailersAdapter = new NowPlayingTrailersAdapter(results, getContext());
                        mTrailersRV.setAdapter(mNowPlayingTrailersAdapter);
                    }
                } else {
                    Toast.makeText(getContext(), response.message().toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<NowPlayingTrailers> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage().toString(), Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public static NowPlayingTrailersorVideos getInstance(int movieId) {
        //if (mNowPlayingTrailersorVideos == null) {
        mNowPlayingTrailersorVideos = new NowPlayingTrailersorVideos(movieId);
        return mNowPlayingTrailersorVideos;
        //}
        //return mNowPlayingTrailersorVideos;
    }
}
