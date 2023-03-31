package com.example.demo.controller;

import com.example.demo.entity.AppUser;
import com.example.demo.service.AppService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/noauthcontroller")
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
    public void createUser(@RequestBody AppUser createUserRequest){
        AppUser appUser = new AppUser(
                createUserRequest.getFirstName(),
                createUserRequest.getLastName(),
                createUserRequest.getNickname(),
                createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                createUserRequest.getRole()
        );
        appService.registration(appUser);
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
