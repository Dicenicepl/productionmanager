package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoAuthController {
    //nieautoryzowaniu użytkownicy mają dostęp do tych kontrolerów
    @GetMapping("/menu")
    public String menu(){
        return "noauthMenu";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
