package com.example.demo.repository.impl;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {

    public BookRepositoryImpl(EntityManager em) {
        super(Book.class, em);
    }


    @Override
    public Optional<List<Book>> getBookByAuthorId(int id) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(book)
                        .from(book)
                        .where(book.id.eq(id))
                        .fetch()
        );
    }
}
