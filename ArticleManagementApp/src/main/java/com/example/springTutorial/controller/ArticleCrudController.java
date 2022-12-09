package com.example.springTutorial.controller;

import com.example.springTutorial.Entity.Article;
import com.example.springTutorial.service.ArticleCrudService;
import com.example.springTutorial.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/articles")
public class ArticleCrudController implements CrudController<Article> {


    private final ArticleCrudService articleCrudService;

    public ArticleCrudController(ArticleCrudService articleCrudService) {
        this.articleCrudService = articleCrudService;
    }

    @Override
    public CrudService<Article> getCrudService(){
        return articleCrudService;
    }
}
