package com.example.springcrudbasic.comment.dto;

public record CommentCreateDto(
        String author,
        String content
) { }
