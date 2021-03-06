package com.culture_news.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "affiche", schema = "public")
public class Affiche {
    @Id
    @Column(name = "affiche_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long afficheId;

    @Column(name = "affiche_name")
    private String afficheName;

    @Column(name = "affiche_descriprion")
    private String afficheDescriprion;

    @Column(name = "comment_count")
    private Long  commentCount;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "picture")
    private String picture;

    @Column(name = "short_description")
    private String shortDescription;

    public Long getAfficheId() {
        return afficheId;
    }

    public void setAfficheId(Long afficheId) {
        this.afficheId = afficheId;
    }

    public String getAfficheName() {
        return afficheName;
    }

    public void setAfficheName(String afficheName) {
        this.afficheName = afficheName;
    }

    public String getAfficheDescriprion() {
        return afficheDescriprion;
    }

    public void setAfficheDescriprion(String afficheDescriprion) {
        this.afficheDescriprion = afficheDescriprion;
    }


    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount += commentCount;
    }

    public void setStartCommentsCount(Long commentsCount) {
        this.commentCount = commentsCount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
