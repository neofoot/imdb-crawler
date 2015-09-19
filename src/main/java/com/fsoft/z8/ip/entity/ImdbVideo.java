package com.fsoft.z8.ip.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public final class ImdbVideo {

    @Column(name = "title")
    private String title;
    
    @Column(name = "release_date")
    private Date releaseDate;
    
    @Column(name = "rating")
    private Float rating;
    
    @Column(name = "content_rating_code")
    private String contentRatingCode;
    
    @Id
    @Column(name = "page_id")
    private int pageId;

    public ImdbVideo() {
    }
   
    public ImdbVideo(String title, Date releaseDate, Float rating, String contentRatingCode, int pageId) {
	this.title = title;
	this.releaseDate = releaseDate;
	this.rating = rating;
	this.contentRatingCode = contentRatingCode;
	this.pageId = pageId;
    }

    /**
     * @return the pageId
     */
    public int getPageId() {
        return pageId;
    }

    /**
     * @param pageId the pageId to set
     */
    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the rating
     */
    public Float getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Float rating) {
        this.rating = rating;
    }

    /**
     * @return the contentRatingCode
     */
    public String getContentRatingCode() {
        return contentRatingCode;
    }

    /**
     * @param contentRatingCode the contentRatingCode to set
     */
    public void setContentRatingCode(String contentRatingCode) {
        this.contentRatingCode = contentRatingCode;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("Video(");
	sb.append("title = ").append(this.getTitle()).append("; ");
	sb.append("rating = ").append(this.getRating()).append(")");
	return sb.toString();
    }

    @Override
    public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
    }
}
