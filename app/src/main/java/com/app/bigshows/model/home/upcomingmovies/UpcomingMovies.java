package com.app.bigshows.model.home.upcomingmovies;

/**
 * Created by Ajay Kumar on 7/26/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class UpcomingMovies {

    @SerializedName("dates")
    @Expose
    private Dates dates;
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
    /*public UpcomingMovies() {
    }*/

    /**
     *
     * @param results
     * @param totalResults
     * @param page
     * @param dates
     * @param totalPages
     */
    public UpcomingMovies(Dates dates, Integer page, List<Result> results, Integer totalPages, Integer totalResults) {
        this.dates = dates;
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    /**
     *
     * @return
     * The dates
     */
    public Dates getDates() {
        return dates;
    }

    /**
     *
     * @param dates
     * The dates
     */
    public void setDates(Dates dates) {
        this.dates = dates;
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


    public static class Result {

        @SerializedName("adult")
        @Expose
        private Boolean adult;
        @SerializedName("backdrop_path")
        @Expose
        private String backdropPath;
        @SerializedName("genre_ids")
        @Expose
        private List<Integer> genreIds = new ArrayList<Integer>();
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("original_language")
        @Expose
        private String originalLanguage;
        @SerializedName("original_title")
        @Expose
        private String originalTitle;
        @SerializedName("overview")
        @Expose
        private String overview;
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
        @SerializedName("video")
        @Expose
        private Boolean video;
        @SerializedName("vote_average")
        @Expose
        private Integer voteAverage;
        @SerializedName("vote_count")
        @Expose
        private Integer voteCount;

        /**
         * No args constructor for use in serialization
         *
         */
        public Result() {
        }

        /**
         *
         * @param id
         * @param genreIds
         * @param title
         * @param releaseDate
         * @param overview
         * @param posterPath
         * @param originalTitle
         * @param voteAverage
         * @param originalLanguage
         * @param adult
         * @param backdropPath
         * @param voteCount
         * @param video
         * @param popularity
         */
        public Result(Boolean adult, String backdropPath, List<Integer> genreIds, Integer id, String originalLanguage, String originalTitle, String overview, String releaseDate, String posterPath, Double popularity, String title, Boolean video, Integer voteAverage, Integer voteCount) {
            this.adult = adult;
            this.backdropPath = backdropPath;
            this.genreIds = genreIds;
            this.id = id;
            this.originalLanguage = originalLanguage;
            this.originalTitle = originalTitle;
            this.overview = overview;
            this.releaseDate = releaseDate;
            this.posterPath = posterPath;
            this.popularity = popularity;
            this.title = title;
            this.video = video;
            this.voteAverage = voteAverage;
            this.voteCount = voteCount;
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
         * The video
         */
        public Boolean getVideo() {
            return video;
        }

        /**
         *
         * @param video
         * The video
         */
        public void setVideo(Boolean video) {
            this.video = video;
        }

        /**
         *
         * @return
         * The voteAverage
         */
        public Integer getVoteAverage() {
            return voteAverage;
        }

        /**
         *
         * @param voteAverage
         * The vote_average
         */
        public void setVoteAverage(Integer voteAverage) {
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


    public class Dates {

        @SerializedName("minimum")
        @Expose
        private String minimum;
        @SerializedName("maximum")
        @Expose
        private String maximum;

        /**
         * No args constructor for use in serialization
         *
         */
        public Dates() {
        }

        /**
         *
         * @param minimum
         * @param maximum
         */
        public Dates(String minimum, String maximum) {
            this.minimum = minimum;
            this.maximum = maximum;
        }

        /**
         *
         * @return
         * The minimum
         */
        public String getMinimum() {
            return minimum;
        }

        /**
         *
         * @param minimum
         * The minimum
         */
        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }

        /**
         *
         * @return
         * The maximum
         */
        public String getMaximum() {
            return maximum;
        }

        /**
         *
         * @param maximum
         * The maximum
         */
        public void setMaximum(String maximum) {
            this.maximum = maximum;
        }

    }



}
