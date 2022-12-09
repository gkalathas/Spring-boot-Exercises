package com.example.todoApp.model;


import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "todos")
public class TodoItem {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "title")
    @NotBlank
    private String title;
    @Column(name = "done")
    private boolean done;

    @Column
    private String important;

    public TodoItem() {}

    public TodoItem(String id, String title, boolean done, String important) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.important = important;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }
}
