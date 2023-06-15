package com.sparta.spartapersonaltask.dto;

import com.sparta.spartapersonaltask.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponsePostDto {
    private String title;
    private String content;
    private String password;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ResponsePostDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.password = post.getPassword();
        this.author = post.getAuthor();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
