package com.ohmymoon.springboard.repository;

import com.ohmymoon.springboard.config.JpaConfig;
import com.ohmymoon.springboard.domain.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final  ArticleRepository articleRepository;
    private final  ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired  ArticleRepository articleRepository, @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }


    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorkFine() {

        // Given
        long previousCount = articleRepository.count();

        // When
        Article savedArticle = articleRepository.save(Article.of("mew article", "new content", "#spring"));

        // Then
        List<Article> articleList = articleRepository.findAll();
        Assertions.assertThat(articleRepository.count())
                .isEqualTo(previousCount + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorkFine() {

        // Given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updateHashTag = "#springboot";
        article.setHashtag(updateHashTag);


        // When
        Article savedArticle = articleRepository.save(article);

        // Then
        Assertions.assertThat(savedArticle)
                .hasFieldOrPropertyWithValue("hashtag", updateHashTag);
    }

    @DisplayName("delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorkFine() {

        // Given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int deletedCommentSize = article.getArticleComments().size();


        // When
        articleRepository.delete(article);

        // Then
        Assertions.assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
        Assertions.assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentSize);

    }

}
