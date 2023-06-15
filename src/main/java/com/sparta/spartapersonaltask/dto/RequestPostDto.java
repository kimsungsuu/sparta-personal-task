package com.sparta.spartapersonaltask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
//@Setter
@AllArgsConstructor
public class RequestPostDto {
    private String title;
    private String content;
    private String password;
    private String author;
}
