package com.fsoft.z8.ip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "person_role_video")
@IdClass(ImdbPersonRoleVideoId.class)
public final class ImdbPersonRoleVideo {

    @Id
    @Column(name = "person_id")
    private int personId;
    
    @Id
    @Column(name = "role_name")
    private String roleName;
    
    @Id
    @Column(name = "video_id")
    private int videoId;
    
    public ImdbPersonRoleVideo() {
    }

    public ImdbPersonRoleVideo(int personId, String roleName, int videoId) {
	this.personId = personId;
	this.roleName = roleName;
	this.videoId = videoId;
    }

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
