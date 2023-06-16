package com.sparta.spartapersonaltask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RequestPostDto {
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String password;
    @NotNull
    private String author;
}
