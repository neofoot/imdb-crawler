package com.fsoft.z8.ip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public final class ImdbRole {

    @Id
    @Column(name = "name")
    private String name;

    public ImdbRole() {
    }

    public ImdbRole(String name) {
        this.name = name;
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
        StringBuilder builder = new StringBuilder("Role(");
        builder.append("name = ").append(this.getName()).append(")");
        return builder.toString();
    }
}
