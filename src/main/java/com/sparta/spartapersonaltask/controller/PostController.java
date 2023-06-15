package com.sparta.spartapersonaltask.controller;

import com.sparta.spartapersonaltask.dto.RequestPostDto;
import com.sparta.spartapersonaltask.dto.ResponsePostDto;
import com.sparta.spartapersonaltask.entity.Post;
import com.sparta.spartapersonaltask.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }
    @PostMapping("/posts")
    public ResponsePostDto createPost(@RequestBody RequestPostDto requestPostDto){
        Post post = new Post(requestPostDto);

        postService.save(post);

        ResponsePostDto responsePostDto = new ResponsePostDto(post);

        return responsePostDto;
    }


    @GetMapping("/posts")
    public List<ResponsePostDto> getPost(){
        List<ResponsePostDto> responseDto = postService.findAll().stream()
                .map(ResponsePostDto::new).toList();

        return responseDto;
    }
}
