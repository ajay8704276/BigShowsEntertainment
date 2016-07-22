package com.app.bigshows.model.home.tvshows;

/**
 * Created by Ajay Kumar on 7/13/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AiringTodayTVShowsCredits_CrewWrapper {

    @SerializedName("credit_id")
    @Expose
    private String creditId;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("profile_path")
    @Expose
    private Object profilePath;

    /**
     * No args constructor for use in serialization
     *
     */
   /* public AiringTodayTVShowsCredits_CrewWrapper() {
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
    public AiringTodayTVShowsCredits_CrewWrapper(String creditId, String department, Integer id, String name, String job, Object profilePath) {
        this.creditId = creditId;
        this.department = department;
        this.id = id;
        this.name = name;
        this.job = job;
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
     * The profilePath
     */
    public Object getProfilePath() {
        return profilePath;
    }

    /**
     *
     * @param profilePath
     * The profile_path
     */
    public void setProfilePath(Object profilePath) {
        this.profilePath = profilePath;
    }

}
