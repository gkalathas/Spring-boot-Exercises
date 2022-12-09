package com.example.springTutorial.controller;

import com.example.springTutorial.Entity.Author;
import com.example.springTutorial.service.AuthorCrudService;
import com.example.springTutorial.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authors")
public class AuthorCrudController implements CrudController<Author> {

    private final AuthorCrudService authorCrudService;

    public AuthorCrudController(AuthorCrudService authorCrudService) {
        this.authorCrudService = authorCrudService;
    }

    @Override
    public CrudService<Author> getCrudService(){
        return authorCrudService;
    }
}
