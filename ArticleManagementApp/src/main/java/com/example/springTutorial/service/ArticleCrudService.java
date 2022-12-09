package com.example.springTutorial.service;

import com.example.springTutorial.Entity.Article;
import com.example.springTutorial.Entity.Author;
import com.example.springTutorial.Repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleCrudService implements CrudService<Article> {




    private final ArticleRepository articleRepository;
    private final AuthorCrudService authorCrudService;


    public ArticleCrudService(ArticleRepository articleRepository, AuthorCrudService authorCrudService) {
        this.articleRepository = articleRepository;
        this.authorCrudService = authorCrudService;
    }


    @Override
    public Article create(Article entity) {

        Optional<Author> read = authorCrudService.read(entity.getAuthor().getAuthorId());

        if(!read.isPresent()){
            throw new EntityNotFoundException("this author not exixts");
        }

        Author author = read.get();
        entity.setAuthor(author);

        return articleRepository.save(entity);
    }

    @Override
    public Optional<Article> read(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> read() {
        return articleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);

    }

    @Override
    public Article Update(Article entity, Long id) {
        Optional<Article> oldRecord = read(id);

        if(!oldRecord.isPresent()) {
            return create(entity);
        }
        Article oldRecordActual = oldRecord.get();
        Author oldAuthor = oldRecordActual.getAuthor();
        Long oldId = oldRecordActual.getArticlesID();

        entity.setAuthor(oldAuthor);
        entity.setArticlesID(oldId);

        return articleRepository.save(entity);
    }
}
