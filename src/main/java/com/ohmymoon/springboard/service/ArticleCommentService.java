package com.ohmymoon.springboard.service;

import com.ohmymoon.springboard.dto.ArticleDto;
import com.ohmymoon.springboard.repository.ArticleCommentRepository;
import com.ohmymoon.springboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleDto> searchArticleComment(long l) {
        return List.of();
    }
}
