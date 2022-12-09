package com.example.springTutorial.Repository;

import com.example.springTutorial.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {


    
}
