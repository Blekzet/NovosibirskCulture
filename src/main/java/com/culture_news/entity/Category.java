
package com.culture_news.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue
    private Long categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Transient
    @ManyToMany(mappedBy = "category")
    private Set<News> newsCategory;
    
    
    public Category() {
    }

    public Set<News> getNews_category() {
        return newsCategory;
    }

    public void setNews_category(Set<News> news_category) {
        this.newsCategory = news_category;
    }

    public Long getCategory_id() {
        return categoryId;
    }

    public void setCategory_id(Long category_id) {
        this.categoryId = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
