package com.example.demo.controller;

import com.example.demo.entity.AppUser;
import com.example.demo.service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoAuthController {
    //nieautoryzowaniu użytkownicy mają dostęp do tych kontrolerów
    private final AppService appService;

    public NoAuthController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/menu")
    public String menu(){
        return "noauthMenu";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration/createuser")
    public void createUser(AppUser appUser){
        appService.registration(appUser);
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
//    @PostMapping("/login/authorizing")
//    public void authorize(AppUser appUser){
//        appService.authorityLogin(appUser);
//    }
}
