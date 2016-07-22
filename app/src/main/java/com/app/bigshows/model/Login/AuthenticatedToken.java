package com.app.bigshows.model.Login;

/**
 * Created by Ajay Kumar on 7/16/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthenticatedToken {

    @SerializedName("request_token")
    @Expose
    private String requestToken;
    @SerializedName("success")
    @Expose
    private Boolean success;

    /**
     * No args constructor for use in serialization
     *
     */
    /*public AuthenticatedToken() {
    }
*/
    /**
     *
     * @param requestToken
     * @param success
     */
    public AuthenticatedToken(String requestToken, Boolean success) {
        this.requestToken = requestToken;
        this.success = success;
    }

    /**
     *
     * @return
     * The requestToken
     */
    public String getRequestToken() {
        return requestToken;
    }

    /**
     *
     * @param requestToken
     * The request_token
     */
    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    /**
     *
     * @return
     * The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
