package com.example.demo.repository;


import com.example.demo.dto.AuthorStatistic;
import com.example.demo.entity.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AuthorRepository extends BaseRepository<Author, Integer> {


    public Optional<Author> findAuthorByEmail(String email);

    public Optional<Author> findAuthorByName(String name);


    public List<AuthorStatistic> getAuthorStatistic();


    public List<Author> getAuthors();


}
