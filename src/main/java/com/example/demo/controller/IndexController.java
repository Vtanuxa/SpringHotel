package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String root() {
        return "redirect:/login";  // Корень сайта → логин
    }

    @GetMapping("/index")
    public String index() {
        return "index";  // Ваша страница с кнопками
    }
}