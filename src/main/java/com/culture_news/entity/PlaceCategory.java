package com.culture_news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "places_place_category")
public class PlaceCategory {
    @Id
    @Column(name = "place_place_id")
    private Long placeId;

    @Column(name = "place_category_category_id")
    private Long categoryId;

    public PlaceCategory() {
    }

    public PlaceCategory(Long placeId, Long categoryId) {
        this.placeId = placeId;
        this.categoryId = categoryId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
