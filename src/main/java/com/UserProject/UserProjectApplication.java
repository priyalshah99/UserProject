package com.UserProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UserProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProjectApplication.class, args);
    }

}
