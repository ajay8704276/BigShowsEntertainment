package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AiringTodayTVShowsCredits_CastWrapper {

    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("credit_id")
    @Expose
    private String creditId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_path")
    @Expose
    private String profilePath;
    @SerializedName("order")
    @Expose
    private Integer order;

    /**
     * No args constructor for use in serialization
     *
     */
    /*public AiringTodayTVShowsCredits_CastWrapper() {
    }*/

    /**
     *
     * @param id
     * @param profilePath
     * @param order
     * @param name
     * @param creditId
     * @param character
     */
    public AiringTodayTVShowsCredits_CastWrapper(String character, String creditId, Integer id, String name, String profilePath, Integer order) {
        this.character = character;
        this.creditId = creditId;
        this.id = id;
        this.name = name;
        this.profilePath = profilePath;
        this.order = order;
    }

    /**
     *
     * @return
     * The character
     */
    public String getCharacter() {
        return character;
    }

    /**
     *
     * @param character
     * The character
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     *
     * @return
     * The creditId
     */
    public String getCreditId() {
        return creditId;
    }

    /**
     *
     * @param creditId
     * The credit_id
     */
    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The profilePath
     */
    public String getProfilePath() {
        return profilePath;
    }

    /**
     *
     * @param profilePath
     * The profile_path
     */
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    /**
     *
     * @return
     * The order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     *
     * @param order
     * The order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

}
