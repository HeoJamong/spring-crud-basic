package com.example.springcrudbasic.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 찾아보기
    private Long id;

    private String title;
    private String content;

    // BigInt id, varchar title, context

    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
