package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AiringTodayTVShows_GenreWrapper {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     *
     */
    /*public AiringTodayTVShows_GenreWrapper() {
    }*/

    /**
     *
     * @param id
     * @param name
     */
    public AiringTodayTVShows_GenreWrapper(Integer id, String name) {
        this.id = id;
        this.name = name;
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

}
