package com.sparta.spartapersonaltask.repository;

import com.sparta.spartapersonaltask.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
