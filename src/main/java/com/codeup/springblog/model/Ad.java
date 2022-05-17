//package com.codeup.springblog.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "ads")
//public class Ad {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private long userId;
//    @Column(nullable = false)
//    private String title;
//    @Column(nullable = false)
//    private String description;
//    @Column
//    private int priceInCents;
//
//    public Ad(long id, int priceInCents) {
//        this.id = id;
//        this.priceInCents = priceInCents;
//    }
//
//    public Ad(long id, long userId, String title, String description, int priceInCents) {
//        this.id = id;
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//        this.priceInCents = priceInCents;
//    }
//
//    public Ad() {}
//
//    public Ad(long id, long userId, String title, String description) {
//        this.id = id;
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//    }
//
//    public Ad(long userId, String title, String description) {
//        this.userId = userId;
//        this.title = title;
//        this.description = description;
//    }
//
//    public int getPriceInCents() {
//        return priceInCents;
//    }
//
//    public void setPriceInCents(int priceInCents) {
//        this.priceInCents = priceInCents;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
