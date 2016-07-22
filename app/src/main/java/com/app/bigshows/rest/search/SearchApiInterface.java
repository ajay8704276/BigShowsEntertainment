package com.app.bigshows.rest.search;

import com.app.bigshows.model.search.Search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ajay Kumar on 7/21/2016.
 */

public interface SearchApiInterface {

    @GET("search/keyword")
    Call<Search> getSearchResults(@Query("api_key") String apikey,@Query("query") String query);
}
