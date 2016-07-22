package com.app.bigshows.model.home.tvshows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay Kumar on 7/10/2016.
 */

public class OnTheAir_Results {

    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("popularity")
    @Expose
    private Float popularity;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("vote_average")
    @Expose
    private Float voteAverage;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = new ArrayList<String>();
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("original_name")
    @Expose
    private String originalName;

    /**
     * No args constructor for use in serialization
     *
     */
    /*public OnTheAir_Results() {
    }*/

    /**
     *
     * @param genreIds
     * @param originalName
     * @param originalLanguage
     * @param backdropPath
     * @param voteCount
     * @param id
     * @param originCountry
     * @param overview
     * @param posterPath
     * @param name
     * @param firstAirDate
     * @param voteAverage
     * @param popularity
     */
    public OnTheAir_Results(String posterPath, Float popularity, Integer id, String backdropPath, Float voteAverage, String overview, String firstAirDate, List<String> originCountry, List<Integer> genreIds, String originalLanguage, Integer voteCount, String name, String originalName) {
        this.posterPath = posterPath;
        this.popularity = popularity;
        this.id = id;
        this.backdropPath = backdropPath;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.firstAirDate = firstAirDate;
        this.originCountry = originCountry;
        this.genreIds = genreIds;
        this.originalLanguage = originalLanguage;
        this.voteCount = voteCount;
        this.name = name;
        this.originalName = originalName;
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
    public Float getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(Float popularity) {
        this.popularity = popularity;
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
     * The voteAverage
     */
    public Float getVoteAverage() {
        return voteAverage;
    }

    /**
     *
     * @param voteAverage
     * The vote_average
     */
    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     *
     * @return
     * The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview
     * The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
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
     * The originCountry
     */
    public List<String> getOriginCountry() {
        return originCountry;
    }

    /**
     *
     * @param originCountry
     * The origin_country
     */
    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    /**
     *
     * @return
     * The genreIds
     */
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    /**
     *
     * @param genreIds
     * The genre_ids
     */
    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    /**
     *
     * @return
     * The originalLanguage
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     *
     * @param originalLanguage
     * The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
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

}
