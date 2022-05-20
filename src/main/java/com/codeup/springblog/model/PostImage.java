package com.codeup.springblog.model;


import javax.persistence.*;

@Entity
@Table(name = "post_images")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    private String imageTitle;
    @Column(length = 1000)
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public PostImage(){}

    public PostImage(String imageTitle, String imageUrl, Post post) {
        this.imageTitle = imageTitle;
        this.imageUrl = imageUrl;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
