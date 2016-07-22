package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/14/2016.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirinTodayTVShowsSimilar_TVVideos {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("results")
    @Expose
    private List<AirinTodayTVShowsSimilar_TVVideos_ResultWrapper> results = new ArrayList<AirinTodayTVShowsSimilar_TVVideos_ResultWrapper>();

    /**
     * No args constructor for use in serialization
     *
     */
   /* public AirinTodayTVShowsSimilar_TVVideos() {
    }*/

    /**
     *
     * @param id
     * @param results
     */
    public AirinTodayTVShowsSimilar_TVVideos(Integer id, List<AirinTodayTVShowsSimilar_TVVideos_ResultWrapper> results) {
        this.id = id;
        this.results = results;
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
     * The results
     */
    public List<AirinTodayTVShowsSimilar_TVVideos_ResultWrapper> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<AirinTodayTVShowsSimilar_TVVideos_ResultWrapper> results) {
        this.results = results;
    }

}
