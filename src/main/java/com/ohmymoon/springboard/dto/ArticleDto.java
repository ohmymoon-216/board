package com.ohmymoon.springboard.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.ohmymoon.springboard.domain.Article} entity
 */
@Data
public class ArticleDto {

    public static ArticleDto of(LocalDateTime createdAt, String createdBy, String title, String content, String hashtag) {
        return new ArticleDto(createdAt, createdBy, title, content, hashtag);
    }

    private final LocalDateTime createdAt;
    private final String createdBy;
    private final String title;
    private final String content;
    private final String hashtag;
}