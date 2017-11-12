package com.teodorstoev.camunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class PlaygroundApplication {
    public static void main(String... args) {
        SpringApplication.run(PlaygroundApplication.class, args);
    }
}
