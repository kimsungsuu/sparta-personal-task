package com.sparta.spartapersonaltask.service;

import com.sparta.spartapersonaltask.dto.RequestPostDto;
import com.sparta.spartapersonaltask.dto.ResponsePostDto;
import com.sparta.spartapersonaltask.entity.Post;
import com.sparta.spartapersonaltask.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 게시글 저장
    @Transactional
    public ResponsePostDto save(RequestPostDto requestPostDto) {
        Post post = new Post(requestPostDto);
        postRepository.save(post);
        return new ResponsePostDto(post);
    }

    // 게시글 전체 조회
    public List<ResponsePostDto> findAll() {
        return postRepository.findAllByOrderByModifiedAtDesc().stream().map(ResponsePostDto::new).toList();
    }

    // 단건 조회
    public ResponsePostDto findById(Long id) {
        Post post = postRepository.findById(id).get();

        return new ResponsePostDto(post);
    }

    // 수정
    @Transactional
    public ResponsePostDto editPost(Long id, RequestPostDto requestPostDto) {
        Post post = postRepository.findById(id).get();

        if(requestPostDto.getPassword().equals(post.getPassword())){
            post.setTitle(requestPostDto.getTitle());
            post.setContent(requestPostDto.getContent());
            post.setAuthor(requestPostDto.getAuthor());
        }else{
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return new ResponsePostDto(post);
    }

    @Transactional
    public String deletePost(Long id, String password) {
        Post post = postRepository.findById(id).get();
        if(post.getPassword().equals(password)){
            postRepository.deleteById(id);
            return "해당 게시글이 삭제되었습니다";
        }else{
            return "게시글 삭제에 실패하였습니다";
        }
    }
}
