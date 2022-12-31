package com.ohmymoon.springboard.service;

import com.ohmymoon.springboard.domain.Article;
import com.ohmymoon.springboard.domain.type.SearchType;
import com.ohmymoon.springboard.dto.ArticleDto;
import com.ohmymoon.springboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameter_whenSearchingArticles_thenReturnsArticleList(){

        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");

        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글ㅇ ㄹ 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticles_thenReturnsArticle(){

        ArticleDto article = sut.searchArticle(1L);

        assertThat(article).isNotNull();
    }

    @DisplayName("게시글을 정보를 입력하면, 게시글을 생성한다..")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSaveArticle(){
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(), "moon", "title", "content", "hashtag");

        Article article = sut.saveArticle(dto);
        assertThat(article.getId()).isGreaterThan(0L);

    }

    @DisplayName("게시글의 아이디와 수정정보를 입력하면, 게시글을 수정한다..")
    @Test
    void givenArticleIfo_whenUpdatingArticle_thenUpdateArticle(){
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(), "moon", "title", "content", "hashtag");

        Article article = sut.updateArticle(1L, dto);
        assertThat(article.getId()).isGreaterThan(0L);

    }

    @DisplayName("게시글의 아이디를 입력하면, 게시글을 삭제한다..")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeleteArticle(){

        sut.deleteArticle(1L);

    }
}