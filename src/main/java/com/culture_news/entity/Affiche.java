package com.culture_news.entity;

import javax.persistence.*;

@Entity
@Table(name = "affiche", schema = "public")
public class Affiche {
    @Id
    @Column(name = "affiche_id")
    @GeneratedValue
    private int affiche_id;

    @Column(name = "affiche_name")
    private String affiche_name;

    @Column(name = "affiche_descriprion")
    private String affiche_descriprion;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment_id")
    private int comment_id;

    @Column(name = "picture")
    private String picture;

    public int getAffiche_id() {
        return affiche_id;
    }

    public void setAffiche_id(int affiche_id) {
        this.affiche_id = affiche_id;
    }

    public String getAffiche_name() {
        return affiche_name;
    }

    public void setAffiche_name(String affiche_name) {
        this.affiche_name = affiche_name;
    }

    public String getAffiche_descriprion() {
        return affiche_descriprion;
    }

    public void setAffiche_descriprion(String affiche_descriprion) {
        this.affiche_descriprion = affiche_descriprion;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
