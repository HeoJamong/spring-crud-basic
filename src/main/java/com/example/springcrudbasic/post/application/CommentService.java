package com.example.springcrudbasic.post.application;

import com.example.springcrudbasic.post.dao.CommentRepository;
import com.example.springcrudbasic.post.dao.PostRepository;
import com.example.springcrudbasic.post.dto.CommentCreateDto;
import com.example.springcrudbasic.post.entity.Comment;
import com.example.springcrudbasic.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public void createComment(Long postId, CommentCreateDto dto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        Comment comment = Comment.builder()
                .author(dto.author())
                .content(dto.content())
                .post(post)
                .build();

        commentRepository.save(comment);
    }
}
