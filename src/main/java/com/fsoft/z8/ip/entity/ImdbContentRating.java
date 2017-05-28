package com.fsoft.z8.ip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "content_rating")
public final class ImdbContentRating {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    public ImdbContentRating() {
    }

    public ImdbContentRating(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ContentRating(");
        sb.append("code = ").append(this.getCode()).append("; ");
        sb.append("name = ").append(this.getName()).append(")");
        return sb.toString();
    }


}
