package com.example.springcrudbasic.post.dto;

import com.example.springcrudbasic.post.entity.Comment;
import java.time.LocalDateTime;

public record CommentDto(Long id, String author, String content, LocalDateTime createdAt) {
    public static CommentDto from(Comment comment){
        String content = comment.isDeleted() ? "삭제된 댓글입니다." : comment.getContent();

        return new CommentDto(
                comment.getId(),
                comment.getAuthor(),
                content,
                comment.getCreatedAt()
        );
    }
}
