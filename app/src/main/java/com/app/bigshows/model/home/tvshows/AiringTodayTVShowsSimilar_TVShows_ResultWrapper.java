package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/14/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AiringTodayTVShowsSimilar_TVShows_ResultWrapper {

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

    /**
     * No args constructor for use in serialization
     *
     */
    /*public AiringTodayTVShowsSimilar_TVShows_ResultWrapper() {
    }*/

    /**
     *
     * @param id
     * @param name
     * @param posterPath
     * @param firstAirDate
     * @param voteAverage
     * @param originalName
     * @param backdropPath
     * @param voteCount
     * @param popularity
     */
    public AiringTodayTVShowsSimilar_TVShows_ResultWrapper(String backdropPath, Integer id, String originalName, String firstAirDate, String posterPath, Double popularity, String name, Double voteAverage, Integer voteCount) {
        this.backdropPath = backdropPath;
        this.id = id;
        this.originalName = originalName;
        this.firstAirDate = firstAirDate;
        this.posterPath = posterPath;
        this.popularity = popularity;
        this.name = name;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    /**
     *
     * @return
     * The backdropPath
     */
    public String getBackdropPath() {
        return backdropPath;
    }

    /**
     *
     * @param backdropPath
     * The backdrop_path
     */
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
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
     * The originalName
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     *
     * @param originalName
     * The original_name
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    /**
     *
     * @return
     * The firstAirDate
     */
    public String getFirstAirDate() {
        return firstAirDate;
    }

    /**
     *
     * @param firstAirDate
     * The first_air_date
     */
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    /**
     *
     * @return
     * The posterPath
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     *
     * @param posterPath
     * The poster_path
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     *
     * @return
     * The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
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
     * The voteAverage
     */
    public Double getVoteAverage() {
        return voteAverage;
    }

    /**
     *
     * @param voteAverage
     * The vote_average
     */
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     *
     * @return
     * The voteCount
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     *
     * @param voteCount
     * The vote_count
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

}
