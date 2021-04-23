package com.example.stocksapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public HomeController() {

    }

    @GetMapping("/")
    public String welcome() {
        return "home";
    }

}
