package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AiringTodayTVShows {

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("created_by")
    @Expose
    private List<AiringTodayTVShows_CreatedByWrapper> createdBy = new ArrayList<AiringTodayTVShows_CreatedByWrapper>();
    @SerializedName("episode_run_time")
    @Expose
    private List<Integer> episodeRunTime = new ArrayList<Integer>();
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("genres")
    @Expose
    private List<AiringTodayTVShows_GenreWrapper> genres = new ArrayList<AiringTodayTVShows_GenreWrapper>();
    @SerializedName("homepage")
    @Expose
    private String homepage;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("in_production")
    @Expose
    private Boolean inProduction;
    @SerializedName("languages")
    @Expose
    private List<String> languages = new ArrayList<String>();
    @SerializedName("last_air_date")
    @Expose
    private String lastAirDate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("networks")
    @Expose
    private List<AiringTodayTVShows_NetworkWrapper> networks = new ArrayList<AiringTodayTVShows_NetworkWrapper>();
    @SerializedName("number_of_episodes")
    @Expose
    private Integer numberOfEpisodes;
    @SerializedName("number_of_seasons")
    @Expose
    private Integer numberOfSeasons;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = new ArrayList<String>();
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("production_companies")
    @Expose
    private List<AiringTodayTVShows_ProductionCompanyWrapper> productionCompanies = new ArrayList<AiringTodayTVShows_ProductionCompanyWrapper>();
    @SerializedName("seasons")
    @Expose
    private List<AiringTodayTVShows_SeasonWrapper> seasons = new ArrayList<AiringTodayTVShows_SeasonWrapper>();
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;
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
   /* public AiringTodayTVShows() {
    }*/

    /**
     *
     * @param networks
     * @param genres
     * @param status
     * @param lastAirDate
     * @param originalName
     * @param originalLanguage
     * @param numberOfSeasons
     * @param type
     * @param backdropPath
     * @param voteCount
     * @param homepage
     * @param numberOfEpisodes
     * @param id
     * @param languages
     * @param originCountry
     * @param overview
     * @param createdBy
     * @param inProduction
     * @param seasons
     * @param posterPath
     * @param name
     * @param firstAirDate
     * @param voteAverage
     * @param productionCompanies
     * @param episodeRunTime
     * @param popularity
     */
    public AiringTodayTVShows(String backdropPath, List<AiringTodayTVShows_CreatedByWrapper> createdBy, List<Integer> episodeRunTime, String firstAirDate, List<AiringTodayTVShows_GenreWrapper> genres, String homepage, Integer id, Boolean inProduction, List<String> languages, String lastAirDate, String name, List<AiringTodayTVShows_NetworkWrapper> networks, Integer numberOfEpisodes, Integer numberOfSeasons, List<String> originCountry, String originalLanguage, String originalName, String overview, Double popularity, String posterPath, List<AiringTodayTVShows_ProductionCompanyWrapper> productionCompanies, List<AiringTodayTVShows_SeasonWrapper> seasons, String status, String type, Double voteAverage, Integer voteCount) {
        this.backdropPath = backdropPath;
        this.createdBy = createdBy;
        this.episodeRunTime = episodeRunTime;
        this.firstAirDate = firstAirDate;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.inProduction = inProduction;
        this.languages = languages;
        this.lastAirDate = lastAirDate;
        this.name = name;
        this.networks = networks;
        this.numberOfEpisodes = numberOfEpisodes;
        this.numberOfSeasons = numberOfSeasons;
        this.originCountry = originCountry;
        this.originalLanguage = originalLanguage;
        this.originalName = originalName;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.seasons = seasons;
        this.status = status;
        this.type = type;
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
     * The createdBy
     */
    public List<AiringTodayTVShows_CreatedByWrapper> getCreatedBy() {
        return createdBy;
    }

    /**
     *
     * @param createdBy
     * The created_by
     */
    public void setCreatedBy(List<AiringTodayTVShows_CreatedByWrapper> createdBy) {
        this.createdBy = createdBy;
    }

    /**
     *
     * @return
     * The episodeRunTime
     */
    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    /**
     *
     * @param episodeRunTime
     * The episode_run_time
     */
    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
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
     * The genres
     */
    public List<AiringTodayTVShows_GenreWrapper> getGenres() {
        return genres;
    }

    /**
     *
     * @param genres
     * The genres
     */
    public void setGenres(List<AiringTodayTVShows_GenreWrapper> genres) {
        this.genres = genres;
    }

    /**
     *
     * @return
     * The homepage
     */
    public String getHomepage() {
        return homepage;
    }

    /**
     *
     * @param homepage
     * The homepage
     */
    public void setHomepage(String homepage) {
        this.homepage = homepage;
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
     * The inProduction
     */
    public Boolean getInProduction() {
        return inProduction;
    }

    /**
     *
     * @param inProduction
     * The in_production
     */
    public void setInProduction(Boolean inProduction) {
        this.inProduction = inProduction;
    }

    /**
     *
     * @return
     * The languages
     */
    public List<String> getLanguages() {
        return languages;
    }

    /**
     *
     * @param languages
     * The languages
     */
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    /**
     *
     * @return
     * The lastAirDate
     */
    public String getLastAirDate() {
        return lastAirDate;
    }

    /**
     *
     * @param lastAirDate
     * The last_air_date
     */
    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
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
     * The networks
     */
    public List<AiringTodayTVShows_NetworkWrapper> getNetworks() {
        return networks;
    }

    /**
     *
     * @param networks
     * The networks
     */
    public void setNetworks(List<AiringTodayTVShows_NetworkWrapper> networks) {
        this.networks = networks;
    }

    /**
     *
     * @return
     * The numberOfEpisodes
     */
    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    /**
     *
     * @param numberOfEpisodes
     * The number_of_episodes
     */
    public void setNumberOfEpisodes(Integer numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    /**
     *
     * @return
     * The numberOfSeasons
     */
    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    /**
     *
     * @param numberOfSeasons
     * The number_of_seasons
     */
    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
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
     * The productionCompanies
     */
    public List<AiringTodayTVShows_ProductionCompanyWrapper> getProductionCompanies() {
        return productionCompanies;
    }

    /**
     *
     * @param productionCompanies
     * The production_companies
     */
    public void setProductionCompanies(List<AiringTodayTVShows_ProductionCompanyWrapper> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    /**
     *
     * @return
     * The seasons
     */
    public List<AiringTodayTVShows_SeasonWrapper> getSeasons() {
        return seasons;
    }

    /**
     *
     * @param seasons
     * The seasons
     */
    public void setSeasons(List<AiringTodayTVShows_SeasonWrapper> seasons) {
        this.seasons = seasons;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
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