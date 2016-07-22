package com.app.bigshows.rest.home;

import com.app.bigshows.model.home.intheater.NowPlaying;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ajay Kumar on 7/22/2016.
 */

public interface NowPlayingApiInterface {


    /**
     * interface for currently playing movies
     * @param apikey
     * @return
     */
    @GET("movie/now_playing")
    Call<NowPlaying> getNowPlayingMovies(@Query("api_key") String apikey);
}
