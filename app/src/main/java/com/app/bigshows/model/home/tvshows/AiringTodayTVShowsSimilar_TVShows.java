package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/14/2016.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AiringTodayTVShowsSimilar_TVShows {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<AiringTodayTVShowsSimilar_TVShows_ResultWrapper> results = new ArrayList<AiringTodayTVShowsSimilar_TVShows_ResultWrapper>();
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    /**
     * No args constructor for use in serialization
     *
     */
    /*public AiringTodayTVShowsSimilar_TVShows() {
    }*/

    /**
     *
     * @param results
     * @param totalResults
     * @param page
     * @param totalPages
     */
    public AiringTodayTVShowsSimilar_TVShows(Integer page, List<AiringTodayTVShowsSimilar_TVShows_ResultWrapper> results, Integer totalPages, Integer totalResults) {
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    /**
     *
     * @return
     * The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The results
     */
    public List<AiringTodayTVShowsSimilar_TVShows_ResultWrapper> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<AiringTodayTVShowsSimilar_TVShows_ResultWrapper> results) {
        this.results = results;
    }

    /**
     *
     * @return
     * The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     *
     * @param totalPages
     * The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     *
     * @return
     * The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     *
     * @param totalResults
     * The total_results
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

}
