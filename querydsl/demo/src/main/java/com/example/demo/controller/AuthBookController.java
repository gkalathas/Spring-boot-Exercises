package com.example.demo.controller;


import com.example.demo.dto.AuthorStatistic;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.service.AuthBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class AuthBookController {

    private AuthBookService authBookService;


    @Autowired
    public AuthBookController(AuthBookService authBookService) {
        this.authBookService = authBookService;
    }


    @PostMapping("/authors/book")
    public List<Author> saveAuthorWithBooks(@RequestBody List<Author> authors) {
        return authBookService.saveAuthorsWithBooks(authors);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authBookService.getAuthors();
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return authBookService.getBooks();
    }

    @GetMapping("/author/{email}")
    public Optional<Author> findAuthorByEmail(@PathVariable String email) {
        return authBookService.findAuthorByEmail(email);
    }

    @GetMapping("/authorStatistic")
    public List<AuthorStatistic> getAuthorStatistic() {
        return authBookService.getAuthorStatistic();
    }

    //to avoid h+1 problem in hibernate or jpa
    @GetMapping("/authors/fetchJoin")
    public List<Author> getAuthorsWithFetchJoin() {
        return authBookService.getAuthorsWithFetchJoin();
    }



}
