package com.example.springcrudbasic.post.controller;

import com.example.springcrudbasic.post.application.CommentService;
import com.example.springcrudbasic.post.dto.CommentCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> createComment(
            @PathVariable Long postId,
            @RequestBody CommentCreateDto dto
    ) {
        commentService.createComment(postId, dto);
        return ResponseEntity.ok().build();
    }
}
