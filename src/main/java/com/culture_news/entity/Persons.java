package com.culture_news.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Persons {

    @Id
    @Column(name = "person_id")
    @GeneratedValue
    private Long personId;
    @Column(name = "person_name")
    private String personName;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "born_date")
    private Date bornDate;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;

    public Persons() {

    }

    public Long getPerson_id() {
        return personId;
    }

    public void setPerson_id(Long person_id) {
        this.personId = person_id;
    }

    public String getPerson_name() {
        return personName;
    }

    public void setPerson_name(String person_name) {
        this.personName = person_name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getBorn_date() {
        return bornDate;
    }

    public void setBorn_date(Date born_date) {
        this.bornDate = born_date;
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
