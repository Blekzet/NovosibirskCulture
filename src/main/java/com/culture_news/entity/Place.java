package com.culture_news.entity;

import javax.persistence.*;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @Column(name = "place_id")
    @GeneratedValue
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

    public Place() {
    }

    public Long getPlace_id() {
        return placeId;
    }

    public void setPlace_id(Long place_id) {
        this.placeId = place_id;
    }

    public String getPlace_name() {
        return placeName;
    }

    public void setPlace_name(String place_name) {
        this.placeName = place_name;
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

    public String getPhone_number() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phone_number;
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
}
