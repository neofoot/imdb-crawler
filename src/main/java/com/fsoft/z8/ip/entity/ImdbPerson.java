package com.fsoft.z8.ip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "person")
public final class ImdbPerson {

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "birth_place")
    private String birthPlace;

    @Id
    @Column(name = "page_id")
    private int pageId;

    public ImdbPerson() {
    }

    public ImdbPerson(String name, Date dob, String birthPlace, int pageId) {
        this.name = name;
        this.dob = dob;
        this.birthPlace = birthPlace;
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

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the birthPlace
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     * @param birthPlace the birthPlace to set
     */
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Person(");
        sb.append("name = ").append(this.getName()).append("; ");
        sb.append("dob = ").append(this.getDob()).append(")");
        return sb.toString();
    }

}
