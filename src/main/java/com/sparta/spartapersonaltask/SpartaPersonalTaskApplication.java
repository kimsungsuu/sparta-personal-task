package com.sparta.spartapersonaltask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaPersonalTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaPersonalTaskApplication.class, args);
    }

}
