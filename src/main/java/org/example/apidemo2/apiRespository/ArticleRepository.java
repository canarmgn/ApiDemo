package org.example.apidemo2.apiRespository;

import org.example.apidemo2.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
