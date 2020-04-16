package com.culture_news.entity;

import javax.persistence.*;

@Entity
@Table(name = "affiche", schema = "public")
public class Affiche {
    @Id
    @Column(name = "affiche_id")
    @GeneratedValue
    private Long afficheId;

    @Column(name = "affiche_name")
    private String afficheName;

    @Column(name = "affiche_descriprion")
    private String afficheDescriprion;

    @Column(name = "rating")
    private Long rating;

    @Column(name = "comment_id")
    private Long  commentId;

    @Column(name = "picture")
    private String picture;

    public Long getAffiche_id() {
        return afficheId;
    }

    public void setAffiche_id(Long affiche_id) {
        this.afficheId = affiche_id;
    }

    public String getAffiche_name() {
        return afficheName;
    }

    public void setAffiche_name(String affiche_name) {
        this.afficheName = affiche_name;
    }

    public String getAffiche_descriprion() {
        return afficheDescriprion;
    }

    public void setAffiche_descriprion(String affiche_descriprion) {
        this.afficheDescriprion = affiche_descriprion;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getComment_id() {
        return afficheId;
    }

    public void setComment_id(Long comment_id) {
        this.commentId = comment_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
