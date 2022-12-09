package com.example.springTutorial.Entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id", nullable = false)
    private Long authorId;

//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//    private String id;

    private String name;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
