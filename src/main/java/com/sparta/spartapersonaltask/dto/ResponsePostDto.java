package com.sparta.spartapersonaltask.dto;

import com.sparta.spartapersonaltask.entity.Post;
import lombok.Getter;

@Getter
public class ResponsePostDto {
    private String title;
    private String content;
    private String password;
    private String author;


    public ResponsePostDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.password = post.getPassword();
        this.author = post.getAuthor();
    }
}
