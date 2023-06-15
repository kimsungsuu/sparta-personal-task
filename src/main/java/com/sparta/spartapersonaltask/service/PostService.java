package com.sparta.spartapersonaltask.service;

import com.sparta.spartapersonaltask.dto.RequestPostDto;
import com.sparta.spartapersonaltask.entity.Post;
import com.sparta.spartapersonaltask.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Long save(Post post){
        postRepository.save(post);
        return post.getId();
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
