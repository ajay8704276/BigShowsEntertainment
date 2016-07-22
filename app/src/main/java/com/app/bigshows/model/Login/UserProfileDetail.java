package com.app.bigshows.model.Login;

/**
 * Created by Ajay Kumar on 7/17/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UserProfileDetail {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("iso_639_1")
    @Expose
    private String iso6391;
    @SerializedName("iso_3166_1")
    @Expose
    private String iso31661;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("include_adult")
    @Expose
    private Boolean includeAdult;
    @SerializedName("username")
    @Expose
    private String username;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserProfileDetail() {
    }

    /**
     *
     * @param iso6391
     * @param id
     * @param username
     * @param iso31661
     * @param name
     * @param includeAdult
     *
     */
    public UserProfileDetail( Integer id, String iso6391, String iso31661, String name, Boolean includeAdult, String username) {
        this.id = id;
        this.iso6391 = iso6391;
        this.iso31661 = iso31661;
        this.name = name;
        this.includeAdult = includeAdult;
        this.username = username;
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
     * The iso6391
     */
    public String getIso6391() {
        return iso6391;
    }

    /**
     *
     * @param iso6391
     * The iso_639_1
     */
    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    /**
     *
     * @return
     * The iso31661
     */
    public String getIso31661() {
        return iso31661;
    }

    /**
     *
     * @param iso31661
     * The iso_3166_1
     */
    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
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
     * The includeAdult
     */
    public Boolean getIncludeAdult() {
        return includeAdult;
    }

    /**
     *
     * @param includeAdult
     * The include_adult
     */
    public void setIncludeAdult(Boolean includeAdult) {
        this.includeAdult = includeAdult;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
