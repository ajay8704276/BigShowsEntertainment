package com.app.bigshows.fragments.home.in_theater;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.bigshows.R;
import com.app.bigshows.model.home.intheater.NowPlayingMovieDetails;
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

public class NowPlayingMovieDetail extends Fragment {

    private static NowPlayingMovieDetail mNowPlayingMovieDetail;
    private int movieId;
    private TextView tvMovieTitle;
    private TextView tvGenres;
    private TextView tvDescription;

    private NowPlayingMovieDetail(int movieId) {

        this.movieId = movieId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.now_playing_movie_details,container,false);

        tvMovieTitle = (TextView) view.findViewById(R.id.tv_title);
        tvGenres = (TextView) view.findViewById(R.id.tv_genres);
        tvDescription = (TextView) view.findViewById(R.id.tv_description);

        //create server request
        startServerRequest(view);
        return view;
    }

    private void startServerRequest(View view) {

        NowPlayingApiInterface mNowPlayingApiInterface = ApiClient.getRetrofitInstance().create(NowPlayingApiInterface.class);
        Call<NowPlayingMovieDetails> mNowPlayingMovieDetailsCall = mNowPlayingApiInterface.getNowPlayingMovieDetail(movieId, Constants.API_KEY);
        mNowPlayingMovieDetailsCall.enqueue(new Callback<NowPlayingMovieDetails>() {
            @Override
            public void onResponse(Call<NowPlayingMovieDetails> call, Response<NowPlayingMovieDetails> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){


                        //Getting list of genre
                        StringBuilder stringBuilder = new StringBuilder();
                        List<NowPlayingMovieDetails.Genre> genre = response.body().getGenres();
                        if(genre!=null){
                            for(int i=0 ; i<genre.size() ;i++){
                                stringBuilder.append(genre.get(i).getName());
                                if(i!= genre.size()){
                                    stringBuilder.append(",");
                                }
                            }
                        }


                        tvMovieTitle.setText(response.body().getTitle());
                        tvGenres.setText(stringBuilder.toString());
                        tvDescription.setText(response.body().getOverview());

                    }
                }else {
                    Toast.makeText(getContext(),response.message(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<NowPlayingMovieDetails> call, Throwable t) {

                Toast.makeText(getContext(),t.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public static NowPlayingMovieDetail getInstance(int movieId) {

        if (mNowPlayingMovieDetail == null) {
            mNowPlayingMovieDetail = new NowPlayingMovieDetail(movieId);
            return mNowPlayingMovieDetail;
        }
        return mNowPlayingMovieDetail;
    }
}
