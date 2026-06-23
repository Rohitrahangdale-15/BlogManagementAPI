package com.rohit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

    @Id
    private Long id;

    private String content;
    private String author;

    public Comment() {
    }

    public Comment(Long id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}