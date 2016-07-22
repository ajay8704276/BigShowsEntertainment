package com.app.bigshows.model;

/**
 * Created by Ajay Kumar on 6/30/2016.
 */

public class GoogleSignInModel {

    private String googleLoginUserName;
    private String googleLoginEmail;
    private String googleLoginImageUrl;

    public String getGoogleLoginUserName() {
        return googleLoginUserName;
    }

    public void setGoogleLoginUserName(String googleLoginUserName) {
        this.googleLoginUserName = googleLoginUserName;
    }

    public String getGoogleLoginEmail() {
        return googleLoginEmail;
    }

    public void setGoogleLoginEmail(String googleLoginEmail) {
        this.googleLoginEmail = googleLoginEmail;
    }

    public String getGoogleLoginImageUrl() {
        return googleLoginImageUrl;
    }

    public void setGoogleLoginImageUrl(String googleLoginImageUrl) {
        this.googleLoginImageUrl = googleLoginImageUrl;
    }
}
