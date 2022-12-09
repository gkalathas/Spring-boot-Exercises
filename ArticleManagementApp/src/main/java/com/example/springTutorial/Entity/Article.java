package com.example.springTutorial.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "articles_id", nullable = false)
    private Long articlesID;

    private String title;
    private String content;

    @ManyToOne
    private Author author;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getArticlesID() {
        return articlesID;
    }

    public void setArticlesID(Long articlesID) {
        this.articlesID = articlesID;
    }
}
