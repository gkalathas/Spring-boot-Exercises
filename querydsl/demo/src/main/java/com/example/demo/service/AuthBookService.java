package com.example.demo.service;


import com.example.demo.dto.AuthorStatistic;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthBookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;


    @Autowired
    public AuthBookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Author> saveAuthorsWithBooks(List<Author> authors) {
        return authorRepository.saveAll(authors);
    }

    //will find h+1 problem
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Author> findAuthorByEmail(String email) {
        return authorRepository.findAuthorByEmail(email);
    }

    public List<AuthorStatistic> getAuthorStatistic() {
        return authorRepository.getAuthorStatistic();
    }

    //to avoid h+1 problem in hibernate or jpa
    public List<Author> getAuthorsWithFetchJoin() {
        return authorRepository.getAuthors();
    }

}
