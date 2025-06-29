package com.example.springcrudbasic.post.dto;

public record CommentCreateDto(
        String author,
        String content
) { }
