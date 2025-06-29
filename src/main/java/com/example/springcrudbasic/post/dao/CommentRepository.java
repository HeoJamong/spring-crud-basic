package com.example.springcrudbasic.post.dao;

import com.example.springcrudbasic.post.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
