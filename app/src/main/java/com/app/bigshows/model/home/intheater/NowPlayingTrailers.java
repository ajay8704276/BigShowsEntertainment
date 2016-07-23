package com.app.bigshows.model.home.intheater;

/**
 * Created by Ajay Kumar on 7/23/2016.
 */

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NowPlayingTrailers {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();

    /**
     * No args constructor for use in serialization
     */
    public NowPlayingTrailers() {
    }

    /**
     * @param id
     * @param results
     */
    public NowPlayingTrailers(Integer id, List<Result> results) {
        this.id = id;
        this.results = results;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }


    public class Result {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("iso_639_1")
        @Expose
        private String iso6391;
        @SerializedName("key")
        @Expose
        private String key;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("site")
        @Expose
        private String site;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("type")
        @Expose
        private String type;

        /**
         * No args constructor for use in serialization
         */
        public Result() {
        }

        /**
         * @param site
         * @param iso6391
         * @param id
         * @param name
         * @param type
         * @param key
         * @param size
         */
        public Result(String id, String iso6391, String key, String name, String site, Integer size, String type) {
            this.id = id;
            this.iso6391 = iso6391;
            this.key = key;
            this.name = name;
            this.site = site;
            this.size = size;
            this.type = type;
        }

        /**
         * @return The id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The iso6391
         */
        public String getIso6391() {
            return iso6391;
        }

        /**
         * @param iso6391 The iso_639_1
         */
        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        /**
         * @return The key
         */
        public String getKey() {
            return key;
        }

        /**
         * @param key The key
         */
        public void setKey(String key) {
            this.key = key;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return The site
         */
        public String getSite() {
            return site;
        }

        /**
         * @param site The site
         */
        public void setSite(String site) {
            this.site = site;
        }

        /**
         * @return The size
         */
        public Integer getSize() {
            return size;
        }

        /**
         * @param size The size
         */
        public void setSize(Integer size) {
            this.size = size;
        }

        /**
         * @return The type
         */
        public String getType() {
            return type;
        }

        /**
         * @param type The type
         */
        public void setType(String type) {
            this.type = type;
        }

    }

}



