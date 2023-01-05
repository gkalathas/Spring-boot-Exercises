package com.example.demo.repository;


import com.example.demo.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BookRepository extends BaseRepository<Book, Integer> {

    public Optional<List<Book>> getBookByAuthorId(int id);
}
