package com.service.yis.controller;

import com.service.yis.domain.User.UserEntity;
import com.service.yis.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class Account {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public String singUp(){
        UserEntity user = UserEntity.builder()
                .user_name("ab")
                .user_pw(passwordEncoder.encode("123"))
                .build();

        userRepository.save(user);
        return "redirect:/account/login";

        /*
        UserEntity user = UserEntity.builder()
                .userName("a")
                .user_password("1234")
                .mobile_number("123")
                .email("sad")
                .service_agreement(1)
                .created_at("2021.01.01")
                .changed_at("2021.01.01")
                .score(3)
                .build();
*/

    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/account/login";
    }

    @GetMapping("/join")
    public String join(){
        return "user/join";
    }



}
