package com.app.bigshows.fragments.home.in_theater;

import android.app.ProgressDialog;
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
import com.app.bigshows.adapters.homepage.intheater.NowPlayingAdapter;
import com.app.bigshows.model.home.intheater.NowPlaying;
import com.app.bigshows.rest.ApiClient;
import com.app.bigshows.rest.home.NowPlayingApiInterface;
import com.app.bigshows.utils.BigShowsGenericDialogHelper;
import com.app.bigshows.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay Kumar on 7/9/2016.
 */

public class Home_InTheater extends Fragment {

    private RecyclerView mRecyclerView;
    private ProgressDialog mDialogHelper;
    private static Home_InTheater mHome_inTheater;

    // Empty constructor required
    public Home_InTheater(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_inthaeter,container,false);

        initializeRecyclerView(view);

        return view;
    }

    private void initializeRecyclerView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_in_theater_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.hasFixedSize();

        //create service
        callNowPlayingService();
    }

    private void callNowPlayingService() {

        //show dialog
        mDialogHelper = BigShowsGenericDialogHelper.builddefaultDialog(getContext(),"Please wait while loadin.. ",false,true);
        mDialogHelper.show();

        NowPlayingApiInterface mNowPlayingApiInterface = ApiClient.getRetrofitInstance().create(NowPlayingApiInterface.class);
        Call<NowPlaying> mNowPlayingCall = mNowPlayingApiInterface.getNowPlayingMovies(Constants.API_KEY);
        mNowPlayingCall.enqueue(new Callback<NowPlaying>() {
            @Override
            public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {

                if(response.isSuccessful()){
                    if(response.body()!=null){
                        mDialogHelper.dismiss();
                        List<NowPlaying.Result> mResult = response.body().getResults();
                        NowPlayingAdapter mAdapter = new NowPlayingAdapter(mResult,R.layout.now_playing_movie_card,getContext());
                        mRecyclerView.setAdapter(mAdapter);
                    }
                }else{
                    Toast.makeText(getContext(),"Error "+response.message(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<NowPlaying> call, Throwable t) {

                Toast.makeText(getContext(),"Error "+t.getCause().toString(),Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        BigShowsEntertainmentApp.getSingleInstance().trackScreenView(Constants.SCREEN_NAME_HOME_IN_THEATER);
    }

    public static Home_InTheater newInstance(){

        if(mHome_inTheater==null){
            return new Home_InTheater();
        }
        return mHome_inTheater;
    }

}
