package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AiringTodayTVShowsCredits {

    @SerializedName("cast")
    @Expose
    private List<AiringTodayTVShowsCredits_CastWrapper> cast = new ArrayList<AiringTodayTVShowsCredits_CastWrapper>();
    @SerializedName("crew")
    @Expose
    private List<AiringTodayTVShowsCredits_CrewWrapper> crew = new ArrayList<AiringTodayTVShowsCredits_CrewWrapper>();
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * No args constructor for use in serialization
     *
     */
   /* public AiringTodayTVShowsCredits() {
    }*/

    /**
     *
     * @param id
     * @param cast
     * @param crew
     */
    public AiringTodayTVShowsCredits(List<AiringTodayTVShowsCredits_CastWrapper> cast, List<AiringTodayTVShowsCredits_CrewWrapper> crew, Integer id) {
        this.cast = cast;
        this.crew = crew;
        this.id = id;
    }

    /**
     *
     * @return
     * The cast
     */
    public List<AiringTodayTVShowsCredits_CastWrapper> getCast() {
        return cast;
    }

    /**
     *
     * @param cast
     * The cast
     */
    public void setCast(List<AiringTodayTVShowsCredits_CastWrapper> cast) {
        this.cast = cast;
    }

    /**
     *
     * @return
     * The crew
     */
    public List<AiringTodayTVShowsCredits_CrewWrapper> getCrew() {
        return crew;
    }

    /**
     *
     * @param crew
     * The crew
     */
    public void setCrew(List<AiringTodayTVShowsCredits_CrewWrapper> crew) {
        this.crew = crew;
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
