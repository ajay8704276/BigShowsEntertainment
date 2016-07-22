package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AiringTodayTVShows_ProductionCompanyWrapper {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * No args constructor for use in serialization
     *
     */
   /* public AiringTodayTVShows_ProductionCompanyWrapper() {
    }*/

    /**
     *
     * @param id
     * @param name
     */
    public AiringTodayTVShows_ProductionCompanyWrapper(String name, Integer id) {
        this.name = name;
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

}
