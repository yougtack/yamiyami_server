package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
    private static final Logger logger = LoggerFactory.getLogger(AopController.class);

    @GetMapping("/hello")
    public void hello() {
        logger.info("hello AOP");
    }
}
