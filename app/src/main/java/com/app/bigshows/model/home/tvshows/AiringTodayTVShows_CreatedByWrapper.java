package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AiringTodayTVShows_CreatedByWrapper {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile_path")
    @Expose
    private Object profilePath;

    /**
     * No args constructor for use in serialization
     *
     */
    /*public AiringTodayTVShows_CreatedByWrapper() {
    }*/

    /**
     *
     * @param id
     * @param profilePath
     * @param name
     */
    public AiringTodayTVShows_CreatedByWrapper(Integer id, String name, Object profilePath) {
        this.id = id;
        this.name = name;
        this.profilePath = profilePath;
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
    public Object getProfilePath() {
        return profilePath;
    }

    /**
     *
     * @param profilePath
     * The profile_path
     */
    public void setProfilePath(Object profilePath) {
        this.profilePath = profilePath;
    }

}
