package com.app.bigshows.model.People;

/**
 * Created by Ajay Kumar on 8/3/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class People {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();
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
    public People() {
    }

    /**
     *
     * @param results
     * @param totalResults
     * @param page
     * @param totalPages
     */
    public People(Integer page, List<Result> results, Integer totalPages, Integer totalResults) {
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
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Result> results) {
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






    public class KnownFor {

        @SerializedName("adult")
        @Expose
        private Boolean adult;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("release_date")
        @Expose
        private String releaseDate;
        @SerializedName("poster_path")
        @Expose
        private String posterPath;
        @SerializedName("popularity")
        @Expose
        private Double popularity;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("vote_average")
        @Expose
        private Double voteAverage;
        @SerializedName("vote_count")
        @Expose
        private Integer voteCount;
        @SerializedName("media_type")
        @Expose
        private String mediaType;

        /**
         * No args constructor for use in serialization
         *
         */
        public KnownFor() {
        }

        /**
         *
         * @param id
         * @param title
         * @param releaseDate
         * @param posterPath
         * @param originalTitle
         * @param voteAverage
         * @param adult
         * @param backdropPath
         * @param voteCount
         * @param mediaType
         * @param popularity
         */
        public KnownFor(Boolean adult, String backdropPath, Integer id, String originalTitle, String releaseDate, String posterPath, Double popularity, String title, Double voteAverage, Integer voteCount, String mediaType) {
            this.adult = adult;
            this.backdropPath = backdropPath;
            this.id = id;
            this.originalTitle = originalTitle;
            this.releaseDate = releaseDate;
            this.posterPath = posterPath;
            this.popularity = popularity;
            this.title = title;
            this.voteAverage = voteAverage;
            this.voteCount = voteCount;
            this.mediaType = mediaType;
        }

        /**
         *
         * @return
         * The adult
         */
        public Boolean getAdult() {
            return adult;
        }

        /**
         *
         * @param adult
         * The adult
         */
        public void setAdult(Boolean adult) {
            this.adult = adult;
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
         * The originalTitle
         */
        public String getOriginalTitle() {
            return originalTitle;
        }

        /**
         *
         * @param originalTitle
         * The original_title
         */
        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        /**
         *
         * @return
         * The releaseDate
         */
        public String getReleaseDate() {
            return releaseDate;
        }

        /**
         *
         * @param releaseDate
         * The release_date
         */
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
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
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
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

        /**
         *
         * @return
         * The mediaType
         */
        public String getMediaType() {
            return mediaType;
        }

        /**
         *
         * @param mediaType
         * The media_type
         */
        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

    }



    public static class Result {

        @SerializedName("adult")
        @Expose
        private Boolean adult;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("known_for")
        @Expose
        private List<KnownFor> knownFor = new ArrayList<KnownFor>();
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("popularity")
        @Expose
        private Double popularity;
        @SerializedName("profile_path")
        @Expose
        private String profilePath;

        /**
         * No args constructor for use in serialization
         *
         */
        public Result() {
        }

        /**
         *
         * @param id
         * @param profilePath
         * @param knownFor
         * @param name
         * @param adult
         * @param popularity
         */
        public Result(Boolean adult, Integer id, List<KnownFor> knownFor, String name, Double popularity, String profilePath) {
            this.adult = adult;
            this.id = id;
            this.knownFor = knownFor;
            this.name = name;
            this.popularity = popularity;
            this.profilePath = profilePath;
        }


        /**
         *
         * @return
         * The adult
         */
        public Boolean getAdult() {
            return adult;
        }

        /**
         *
         * @param adult
         * The adult
         */
        public void setAdult(Boolean adult) {
            this.adult = adult;
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
         * The knownFor
         */
        public List<KnownFor> getKnownFor() {
            return knownFor;
        }

        /**
         *
         * @param knownFor
         * The known_for
         */
        public void setKnownFor(List<KnownFor> knownFor) {
            this.knownFor = knownFor;
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

    }

}

