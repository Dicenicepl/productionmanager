package com.example.demo;

import com.example.demo.entity.AppUser;
import com.example.demo.role.Role;
import com.example.demo.service.AppService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private AppService appService;

    @Test
    void contextLoads() {
        appService.registration(new AppUser(
                "Aleksander",
                "Królik",
                "Dicenice",
                "Dicenicepl@gmail.com",
                "password", Role.ADMIN));
    }

}
