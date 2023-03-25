package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppService {

    private final UserRepository userRepository;


    public void registration(AppUser appUser){
            userRepository.save(appUser);
    }


}
