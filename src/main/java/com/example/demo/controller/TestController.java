package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "hello";
    }
    @GetMapping("/users/{id}")
    public String users(@PathVariable Long id) {
        return String.valueOf(id);
    }
}
