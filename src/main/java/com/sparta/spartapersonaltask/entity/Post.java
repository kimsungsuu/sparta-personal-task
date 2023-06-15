package com.sparta.spartapersonaltask.entity;

import com.sparta.spartapersonaltask.dto.RequestPostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="post")
@NoArgsConstructor
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false)
    private String title;

    public Post(RequestPostDto requestPostDto) {
        this.title = requestPostDto.getTitle();
        this.author = requestPostDto.getAuthor();
        this.content = requestPostDto.getContent();
        this.password = requestPostDto.getPassword();
    }
}
