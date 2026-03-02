package com.example.pipeline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from the Midterm Pipeline!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}