package com.app.bigshows.rest.people;

import com.app.bigshows.model.People.People;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ajay Kumar on 8/3/2016.
 */

public interface PopularPeopleApiInterface {

    /**
     * interface to get paopular people in industry
     * @param api_key
     * @return
     */

    @GET("person/popular")
    Call<People> getPopularPeople(@Query("api_key") String api_key,@Query("page") int currentPage);
}
