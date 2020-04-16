/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.culture_news.entity;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue
    private Long commentId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "text")
    private String text;

    @Column(name = "rating")
    private Long rating;

    public Comments() {
    }

    public Long getComment_id() {
        return commentId;
    }

    public void setComment_id(Long comment_id) {
        this.commentId = comment_id;
    }

    public Long getUser_id() {
        return userId;
    }

    public void setUser_id(Long user_id) {
        this.userId = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
    
}
