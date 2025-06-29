package com.example.springcrudbasic.post.dto;

import com.example.springcrudbasic.post.entity.Post;

public record PostDto(Long id, String title, String content, int viewCount) {

    public static PostDto from (Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getViewCount());
    }
}
