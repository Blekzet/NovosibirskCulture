/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.culture_news.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "news")
public class News {

    @Id
    @Column(name = "news_id")
    @GeneratedValue
    private int news_id;

    @Column(name = "title")
    private String title;

    @Column(name = "short_description")
    private String short_description;

    @Column(name = "full_description")
    private String full_description;

    @Column(name = "comments_count")
    private int comments_count;

    @Column(name = "date")
    private Date date;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment_id")
    private int comment_id;

    @Column(name = "picture")
    private String picture;

    @Transient
    @ManyToMany(mappedBy = "news")
    private Set<Category> news_category;

    public News() {
    }

    public Set<Category> getNews_category() {
        return news_category;
    }

    public void setNews_category(Set<Category> news_category) {
        this.news_category = news_category;
    }
    
    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
