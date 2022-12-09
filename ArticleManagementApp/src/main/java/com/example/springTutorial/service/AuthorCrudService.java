package com.example.springTutorial.service;

import com.example.springTutorial.Entity.Author;
import com.example.springTutorial.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorCrudService implements CrudService<Author> {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorCrudService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author entity) {
        return authorRepository.save(entity);
    }

    @Override
    public Optional<Author> read(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> read() {
        return authorRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author Update(Author entity, Long id) {
        Optional<Author> oldAuthor = read(id);

        if(!oldAuthor.isPresent()){
           return create(entity);
        }
        Author oldAuthorActual = oldAuthor.get();

        Long oldId = oldAuthorActual.getAuthorId();

        entity.setAuthorId(oldId);

        return authorRepository.save(entity);
    }
}
