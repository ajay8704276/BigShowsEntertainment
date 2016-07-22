package com.app.bigshows.rest.login;

import com.app.bigshows.model.Login.AuthenticatedToken;
import com.app.bigshows.model.Login.Token;
import com.app.bigshows.model.Login.UserProfileDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ajay Kumar on 7/16/2016.
 */

public interface LoginApiInterface {

    /**
     * Request new token to generate valid session
     * @param apikey
     * @return
     */
    @GET("authentication/token/new")
    Call<Token> getToken(@Query("api_key") String apikey);


    /**
     *
     * @param apikey
     * @param token
     * @param username
     * @param password
     * @return
     */
    @GET("authentication/token/validate_with_login")
    Call<AuthenticatedToken> getAuthenticatedUserTokenOrSession(@Query("api_key") String apikey, @Query("request_token") String token, @Query("username") String username, @Query("password") String password);


    /**
     *
     * @param api_key
     * @param session_id
     * @return
     */
    @GET("account")
    Call<UserProfileDetail> getUserProfileDetail(@Query("api_key") String api_key ,@Query("session_id") String session_id);

}
