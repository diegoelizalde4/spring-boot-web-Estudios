package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String home(){
        return "forward:/app/index";
    }
}
