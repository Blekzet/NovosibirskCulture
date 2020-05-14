package com.culture_news.entity;


import javax.persistence.*;

@Entity
@Table(name = "news_news_category")
public class NewsCategory {

    @Id
    @Column(name = "news_news_id")
    private Long newsId;

    @Column(name = "news_category_category_id")
    private Long categoryId;

    public NewsCategory() {
    }

    public NewsCategory(Long newsId, Long categoryId) {
        this.newsId = newsId;
        this.categoryId = categoryId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
