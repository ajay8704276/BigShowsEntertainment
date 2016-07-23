package com.app.bigshows.model.home.intheater;

/**
 * Created by Ajay Kumar on 7/23/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class NowPlayingCreditsModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cast")
    @Expose
    private List<Cast> cast = new ArrayList<Cast>();
    @SerializedName("crew")
    @Expose
    private List<Crew> crew = new ArrayList<Crew>();

    /**
     * No args constructor for use in serialization
     *
     */
   /* public NowPlayingCreditsModel() {
    }*/

    /**
     *
     * @param id
     * @param cast
     * @param crew
     */
    public NowPlayingCreditsModel(Integer id, List<Cast> cast, List<Crew> crew) {
        this.id = id;
        this.cast = cast;
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

    /**
     *
     * @return
     * The cast
     */
    public List<Cast> getCast() {
        return cast;
    }

    /**
     *
     * @param cast
     * The cast
     */
    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    /**
     *
     * @return
     * The crew
     */
    public List<Crew> getCrew() {
        return crew;
    }

    /**
     *
     * @param crew
     * The crew
     */
    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }


    public class Cast {

        @SerializedName("cast_id")
        @Expose
        private Integer castId;
        @SerializedName("character")
        @Expose
        private String character;
        @SerializedName("credit_id")
        @Expose
        private String creditId;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("order")
        @Expose
        private Integer order;
        @SerializedName("profile_path")
        @Expose
        private String profilePath;

        /**
         * No args constructor for use in serialization
         *
         */
       /* public Cast() {
        }*/

        /**
         *
         * @param id
         * @param profilePath
         * @param order
         * @param castId
         * @param name
         * @param creditId
         * @param character
         */
        public Cast(Integer castId, String character, String creditId, Integer id, String name, Integer order, String profilePath) {
            this.castId = castId;
            this.character = character;
            this.creditId = creditId;
            this.id = id;
            this.name = name;
            this.order = order;
            this.profilePath = profilePath;
        }

        /**
         *
         * @return
         * The castId
         */
        public Integer getCastId() {
            return castId;
        }

        /**
         *
         * @param castId
         * The cast_id
         */
        public void setCastId(Integer castId) {
            this.castId = castId;
        }

        /**
         *
         * @return
         * The character
         */
        public String getCharacter() {
            return character;
        }

        /**
         *
         * @param character
         * The character
         */
        public void setCharacter(String character) {
            this.character = character;
        }

        /**
         *
         * @return
         * The creditId
         */
        public String getCreditId() {
            return creditId;
        }

        /**
         *
         * @param creditId
         * The credit_id
         */
        public void setCreditId(String creditId) {
            this.creditId = creditId;
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
         * The order
         */
        public Integer getOrder() {
            return order;
        }

        /**
         *
         * @param order
         * The order
         */
        public void setOrder(Integer order) {
            this.order = order;
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


    public class Crew {

        @SerializedName("credit_id")
        @Expose
        private String creditId;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("job")
        @Expose
        private String job;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("profile_path")
        @Expose
        private String profilePath;

        /**
         * No args constructor for use in serialization
         *
         */
       /* public Crew() {
        }*/

        /**
         *
         * @param id
         * @param profilePath
         * @param department
         * @param name
         * @param job
         * @param creditId
         */
        public Crew(String creditId, String department, Integer id, String job, String name, String profilePath) {
            this.creditId = creditId;
            this.department = department;
            this.id = id;
            this.job = job;
            this.name = name;
            this.profilePath = profilePath;
        }

        /**
         *
         * @return
         * The creditId
         */
        public String getCreditId() {
            return creditId;
        }

        /**
         *
         * @param creditId
         * The credit_id
         */
        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        /**
         *
         * @return
         * The department
         */
        public String getDepartment() {
            return department;
        }

        /**
         *
         * @param department
         * The department
         */
        public void setDepartment(String department) {
            this.department = department;
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
         * The job
         */
        public String getJob() {
            return job;
        }

        /**
         *
         * @param job
         * The job
         */
        public void setJob(String job) {
            this.job = job;
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
