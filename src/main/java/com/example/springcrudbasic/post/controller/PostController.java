package com.example.springcrudbasic.post.controller;

import com.example.springcrudbasic.post.application.PostService;
import com.example.springcrudbasic.post.dto.PostCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostCreateDto postCreateDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postCreateDto));
    }

    @GetMapping
    public ResponseEntity<?> findAllPost() {
        return ResponseEntity.ok().body(postService.findAll());
    }

    @PutMapping("{postId}")
    public ResponseEntity<?> updatePost(@PathVariable Long postId, @RequestBody PostCreateDto postCreateDto) {
        return ResponseEntity.ok().body(postService.updatePost(postId, postCreateDto));
    }

    @GetMapping("{postId}")
    public ResponseEntity<?> getPost(@PathVariable Long postId) {
        return  ResponseEntity.ok(postService.getPost(postId));
    }
}
