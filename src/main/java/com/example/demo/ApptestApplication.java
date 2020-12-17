package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAspectJAutoProxy
@SpringBootApplication
public class ApptestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApptestApplication.class, args);
    }

}
