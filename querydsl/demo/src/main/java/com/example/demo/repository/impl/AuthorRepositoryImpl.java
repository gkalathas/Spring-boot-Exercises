package com.example.demo.repository.impl;

import com.example.demo.dto.AuthorStatistic;
import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.querydsl.core.types.Projections;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author, Integer> implements AuthorRepository {

    public AuthorRepositoryImpl(EntityManager em) {
        super(Author.class, em);
    }

    @Override
    public Optional<Author> findAuthorByEmail(String email) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(author)
                        .from(author)
                        .where(author.email.equalsIgnoreCase(email))
                        .fetchFirst()
        );
    }
    @Override
    public Optional<Author> findAuthorByName(String name) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .select(author)
                        .from(author)
                        .where(author.name.equalsIgnoreCase(name))
                        .fetchFirst()
        );
    }

    @Override
    public List<AuthorStatistic> getAuthorStatistic() {
        return jpaQueryFactory
                .select(Projections.constructor(AuthorStatistic.class, author.name, book.count()))
                .from(author)
                .innerJoin(author.books, book)
                .groupBy(author.name)
                .fetch();
    }

    @Override
    public List<Author> getAuthors() {
        return jpaQueryFactory
                .select(author)
                .from(author)
                .innerJoin(author.books, book)
                .fetchJoin()
                .fetch();
    }


}
