package com.sparta.spartapersonaltask;

import com.sparta.spartapersonaltask.entity.Post;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

/**
 * 기능 : DB 데이터 자동 저장
 */
@Component
public class InitDb {
    private final InitService initService;

    public InitDb(InitService initService){
        this.initService = initService;
    }

    // 초기화 메서드
    @PostConstruct
    public void init(){
        initService.dbInit1();
    }

    @Component
    @Transactional
    static class InitService{

        private final EntityManager em;

        public InitService(EntityManager em){
            this.em = em;
        }

        public void dbInit1(){
            Post post = createPost("title","kimsungsu","content","123");

            em.persist(post);
        }

        private static Post createPost(String title, String author, String content, String password) {
            Post post = new Post();
            post.setTitle(title);
            post.setAuthor(author);
            post.setContent(content);
            post.setPassword(password);
            return post;
        }
    }
}
