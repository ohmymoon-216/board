package com.ohmymoon.springboard.service;

import com.ohmymoon.springboard.domain.Article;
import com.ohmymoon.springboard.domain.type.SearchType;
import com.ohmymoon.springboard.dto.ArticleCommentDto;
import com.ohmymoon.springboard.dto.ArticleDto;
import com.ohmymoon.springboard.repository.ArticleCommentRepository;
import com.ohmymoon.springboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("비즈니스 로직 - 댓글글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {
    @InjectMocks
    private ArticleCommentService sut;

    @Mock
    private ArticleCommentRepository articleCommentRepository;

    @DisplayName("게시글을 아이디로 검색하면, 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticleComment_thenReturnsArticleCommentList(){

        List<ArticleDto> articles = sut.searchArticleComment(1L);

        assertThat(articles).isNotNull();
    }


}