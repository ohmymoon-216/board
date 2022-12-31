package com.ohmymoon.springboard.service;

import com.ohmymoon.springboard.domain.Article;
import com.ohmymoon.springboard.domain.type.SearchType;
import com.ohmymoon.springboard.dto.ArticleDto;
import com.ohmymoon.springboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType title, String search_keyword){
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(Long articleId){
        return null;
    }

    public Article saveArticle(ArticleDto dto) {
        return null;
    }

    public Article updateArticle(long l, ArticleDto dto) {
        return null;
    }

    public void deleteArticle(long articleId) {
    }
}
