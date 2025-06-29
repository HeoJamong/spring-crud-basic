package com.example.springcrudbasic.post.application;

import com.example.springcrudbasic.post.dao.PostRepository;
import com.example.springcrudbasic.post.dto.PostCreateDto;
import com.example.springcrudbasic.post.dto.PostDto;
import com.example.springcrudbasic.post.entity.Post;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostDto createPost(PostCreateDto postCreateDto) {
        Post post = Post.builder()
                .title(postCreateDto.title())
                .content(postCreateDto.content())
                .build();

        postRepository.save(post);

        return PostDto.from(post);
    }

    @Transactional(readOnly = true)
    public List<PostDto> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostDto::from)
                .toList();
    }

    public PostDto updatePost(Long postId, PostCreateDto postCreateDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow();

        post.updatePost(postCreateDto.title(), postCreateDto.content());
        return PostDto.from(post);
    }

    public void deleteById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow();

        postRepository.delete(post);
    }

    @Transactional
    public PostDto getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow();

        post.increaseViewCount();
        return PostDto.from(post);
    }
}
