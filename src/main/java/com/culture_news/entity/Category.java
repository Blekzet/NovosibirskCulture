
package com.culture_news.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    private Long categoryId;

    private String name;

    private String description;

    @Transient
    @ManyToMany(mappedBy = "category")
    private Set<News> newsCategory;

    
    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Category setStartName(String name){
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<News> getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(Set<News> newsCategory) {
        this.newsCategory = newsCategory;
    }

}
