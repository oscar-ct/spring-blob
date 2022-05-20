package com.codeup.springblog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 150)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
    @OneToOne(cascade = CascadeType.ALL)
    PostDetails postDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> postImages = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "post_tag",
            joinColumns = {@JoinColumn(name="post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private List<Tag> postTags = new ArrayList<>();

    public Post(String title, String description, User owner, List<Tag> postTags) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.postTags = postTags;
    }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Post(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Post(long id, String title, String description, User owner) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
    }

    public Post(String title, String description, User owner, PostDetails postDetails) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.postDetails = postDetails;
    }

    public Post() {
    }

    public List<PostImage> getPostImages() {
        return postImages;
    }

    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public List<Tag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<Tag> postTags) {
        this.postTags = postTags;
    }

}
