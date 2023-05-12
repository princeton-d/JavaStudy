package com.example.jdbcboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "user/login-form";
    }

    @GetMapping("/user/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    @GetMapping("/user/signup")
    public String signUp() {
        return "/user/signup";
    }
}
