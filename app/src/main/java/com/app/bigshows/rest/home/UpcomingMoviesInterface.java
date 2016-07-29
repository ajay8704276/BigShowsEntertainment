package com.app.bigshows.rest.home;

import com.app.bigshows.model.home.upcomingmovies.UpcomingMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ajay Kumar on 7/26/2016.
 */

public interface UpcomingMoviesInterface {

    @GET("movie/upcoming")
    Call<UpcomingMovies> getUpcomingMovies(@Query("api_key") String apikey,@Query("page") int cuurentPage);
}
