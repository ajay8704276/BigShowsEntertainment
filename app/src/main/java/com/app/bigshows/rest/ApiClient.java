package com.app.bigshows.rest;

import com.app.bigshows.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ajay Kumar on 7/10/2016.
 */

public class ApiClient {

    //initialising retrofit with null
    public static Retrofit mRetrofit = null;

    public static Retrofit getRetrofitInstance(){

        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.THE_MOVIE_DB_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
