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
    private Long newsId;

    @Column(name = "title")
    private String title;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "comments_count")
    private Long commentsCount;

    @Column(name = "date")
    private Date date;

    @Column(name = "rating")
    private Long rating;

    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "picture")
    private String picture;

    @Transient
    @ManyToMany(mappedBy = "news")
    private Set<Category> newsCategory;

    public News() {
    }

    public Set<Category> getNews_category() {
        return newsCategory;
    }

    public void setNews_category(Set<Category> news_category) {
        this.newsCategory = news_category;
    }
    
    public Long getNews_id() {
        return newsId;
    }

    public void setNews_id(Long news_id) {
        this.newsId = news_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_description() {
        return shortDescription;
    }

    public void setShort_description(String short_description) {
        this.shortDescription = short_description;
    }

    public String getFull_description() {
        return fullDescription;
    }

    public void setFull_description(String full_description) {
        this.fullDescription = full_description;
    }

    public Long getComments_count() {
        return commentsCount;
    }

    public void setComments_count(Long comments_count) {
        this.commentsCount = comments_count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getComment_id() {
        return commentId;
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
