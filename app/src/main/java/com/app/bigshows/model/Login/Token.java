package com.app.bigshows.model.Login;

/**
 * Created by Ajay Kumar on 7/16/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("expires_at")
    @Expose
    private String expiresAt;
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
    /*public Token() {
    }*/

    /**
     *
     * @param expiresAt
     * @param requestToken
     * @param success
     */
    public Token(String expiresAt, String requestToken, Boolean success) {
        this.expiresAt = expiresAt;
        this.requestToken = requestToken;
        this.success = success;
    }

    /**
     *
     * @return
     * The expiresAt
     */
    public String getExpiresAt() {
        return expiresAt;
    }

    /**
     *
     * @param expiresAt
     * The expires_at
     */
    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
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
