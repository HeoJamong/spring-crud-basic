package com.example.springcrudbasic.comment.application;

import com.example.springcrudbasic.comment.dao.CommentRepository;
import com.example.springcrudbasic.comment.dto.CommentUpdateDto;
import com.example.springcrudbasic.global.exception.CommentNotFoundException;
import com.example.springcrudbasic.post.dao.PostRepository;
import com.example.springcrudbasic.comment.dto.CommentCreateDto;
import com.example.springcrudbasic.comment.dto.CommentDto;
import com.example.springcrudbasic.comment.entity.Comment;
import com.example.springcrudbasic.post.entity.Post;
import java.util.List;
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

    @Transactional(readOnly = true)
    public List<CommentDto> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostIdOrderByCreatedAtDesc(postId)
                .stream()
                .map(CommentDto::from)
                .toList();
    }

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException());

        commentRepository.delete(comment);
    }

    @Transactional
    public void updateComment(Long commentId, CommentUpdateDto dto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
        if (comment.isDeleted()) {
            throw new IllegalStateException("삭제된 댓글은 수정할 수 없습니다.");
        }

        comment.updateContent(dto.content());
    }
}
