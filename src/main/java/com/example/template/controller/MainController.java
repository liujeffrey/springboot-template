package com.example.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/template")
public class MainController {
    @GetMapping("/hello")
    public String hellWorld() {
        return "hello world!";
    }
}
