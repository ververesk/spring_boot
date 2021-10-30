package com.grigorovich.springboot.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application { //должен оставться там где был создан

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
