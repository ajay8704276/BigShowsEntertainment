package com.app.bigshows.rest.home;

import com.app.bigshows.model.home.intheater.NowPlaying;
import com.app.bigshows.model.home.intheater.NowPlayingCreditsModel;
import com.app.bigshows.model.home.intheater.NowPlayingMovieDetails;
import com.app.bigshows.model.home.intheater.NowPlayingTrailers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
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

    /**
     * interface for currently playing movies credits
     * @param movieId
     * @param apikey
     * @return
     */
    @GET("movie/{id}/credits")
    Call<NowPlayingCreditsModel> getNowPLayingCredits(@Path("id") int movieId,@Query("api_key") String apikey);


    /**
     * interface for curently playing movies trailers
     * @param movieId
     * @param apikey
     * @return
     */
    @GET("movie/{id}/videos")
    Call<NowPlayingTrailers> getNowPlayingTrailers(@Path("id") int movieId,@Query("api_key") String apikey);


    /**
     * interface currently playing movies details
     * @param movieId
     * @param apikey
     * @return
     */
    @GET("movie/{id}")
    Call<NowPlayingMovieDetails> getNowPlayingMovieDetail(@Path("id") int movieId,@Query("api_key") String apikey);

}
