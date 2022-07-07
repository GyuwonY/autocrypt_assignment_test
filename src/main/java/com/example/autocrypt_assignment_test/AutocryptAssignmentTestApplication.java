package com.example.autocrypt_assignment_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AutocryptAssignmentTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutocryptAssignmentTestApplication.class, args);
    }

}
