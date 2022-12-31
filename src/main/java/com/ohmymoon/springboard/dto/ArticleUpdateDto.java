package com.ohmymoon.springboard.dto;

import lombok.Data;

/**
 * A DTO for the {@link com.ohmymoon.springboard.domain.Article} entity
 */
@Data
public class ArticleUpdateDto {

    public static ArticleUpdateDto of( String title, String content, String hashtag) {
        return new ArticleUpdateDto(title, content, hashtag);
    }

    private final String title;
    private final String content;
    private final String hashtag;
}