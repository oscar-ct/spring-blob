package com.codeup.springblog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String name;
    @ManyToMany(mappedBy = "postTags")
    private List<Post> tagPosts;

    public Tag(){}


    public Tag(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tag(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getTagPosts() {
        return tagPosts;
    }

    public void setTagPosts(List<Post> tagPosts) {
        this.tagPosts = tagPosts;
    }
}
