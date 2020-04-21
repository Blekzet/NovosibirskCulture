package com.culture_news.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @Column(name = "place_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;
    @Column(name = "place_name")
    private String placeName;
    @Column(name = "site")
    private String site;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "description")
    private String description;
    @Column(name = "picture")
    private String picture;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> placeCategory;

    public Place() {
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Set<Category> getPlaceCategory() {
        return placeCategory;
    }

    public void setPlaceCategory(Set<Category> placeCategory) {
        this.placeCategory = placeCategory;
    }
}
