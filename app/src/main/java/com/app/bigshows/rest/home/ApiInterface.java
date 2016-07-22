package com.app.bigshows.rest.home;

import com.app.bigshows.model.home.tvshows.AirinTodayTVShowsSimilar_TVVideos;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShows;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsCredits;
import com.app.bigshows.model.home.tvshows.AiringTodayTVShowsSimilar_TVShows;
import com.app.bigshows.model.home.tvshows.OnTheAir;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ajay Kumar on 7/10/2016.
 */

public interface ApiInterface {

    /**
     * List of Airing Taoday TVShows
     * @param apikey
     * @return
     */
    @GET("tv/on_the_air")
    Call<OnTheAir> getOnTheAirTVShows(@Query("api_key") String apikey);

    /**
     * Airing Today  tv show detail rest service
     */
    @GET("tv/{id}")
    Call<AiringTodayTVShows> getAiringTodayTVShowsDetail(@Path("id") int tvShowID,@Query("api_key") String apikey);


    /**
     * Airing Today tv show crew service
     * @param tvShowID
     * @param apikey
     * @return
     */
    @GET("tv/{id}/credits")
    Call<AiringTodayTVShowsCredits> getAiringTodayTVShpwsCredits(@Path("id") int tvShowID,@Query("api_key") String apikey);


    /**
     * Airing Today similar tv shows
     * @param tvShowID
     * @param apikey
     * @return
     */
    @GET("tv/{id}/similar")
    Call<AiringTodayTVShowsSimilar_TVShows> getAiringTodayTVShowsSimilar(@Path("id") int tvShowID,@Query("api_key") String apikey);


    /**
     * Airing Today TV Videos associated with speific show
     * @param tvShowID
     * @param apikey
     * @return
     */
    @GET("tv/{id}/videos")
    Call<AirinTodayTVShowsSimilar_TVVideos> getAiringTodayTVShowsSimilarTVVideos(@Path("id") int tvShowID, @Query("api_key") String apikey);
}
