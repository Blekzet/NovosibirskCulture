package com.culture_news.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Persons {

    @Id
    @Column(name = "person_id")
    @GeneratedValue
    private int person_id;
    @Column(name = "person_name")
    private String person_name;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "born_date")
    private Date born_date;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;

    public Persons() {

    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getBorn_date() {
        return born_date;
    }

    public void setBorn_date(Date born_date) {
        this.born_date = born_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
