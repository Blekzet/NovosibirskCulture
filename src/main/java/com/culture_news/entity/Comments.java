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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "text")
    private String text;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "news_id")
    private Long newsId;
    @Column(name = "affiche_id")
    private Long afficheId;

    public Comments() {
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Long getAfficheId() {
        return afficheId;
    }

    public void setAfficheId(Long afficheId) {
        this.afficheId = afficheId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
