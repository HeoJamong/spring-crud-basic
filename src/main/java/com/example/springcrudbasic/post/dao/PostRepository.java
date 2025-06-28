package com.example.springcrudbasic.post.dao;

import com.example.springcrudbasic.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
