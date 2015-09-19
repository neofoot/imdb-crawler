package com.fsoft.z8.ip.entity;

import java.io.Serializable;

public final class ImdbPersonRoleVideoId implements Serializable {
    private int personId;
    private String roleName;
    private int videoId;
    
    /**
     * @return the personId
     */
    public int getPersonId() {
        return personId;
    }
    /**
     * @param personId the personId to set
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }
    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    /**
     * @return the videoId
     */
    public int getVideoId() {
        return videoId;
    }
    /**
     * @param videoId the videoId to set
     */
    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
