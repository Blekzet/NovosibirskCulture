package com.culture_news.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Persons {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    @Column(name = "person_name")
    private String personName;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "date")
    private String date;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;

    public Persons() {

    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
