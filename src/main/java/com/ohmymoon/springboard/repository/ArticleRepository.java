package com.ohmymoon.springboard.repository;

import com.ohmymoon.springboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}