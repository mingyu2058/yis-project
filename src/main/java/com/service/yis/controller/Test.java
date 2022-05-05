package com.service.yis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class Test {

    @GetMapping
    public String testMain(){
        return "/test/main-test";
    }

    @GetMapping("/login")
    public String testLogin(){
        return "/test/login-test";
    }

    @GetMapping("/join")
    public String testJoin(){ return "/test/join-test";}

    @GetMapping("/item")
    public String testItem(){return "/test/item-test";}

    @GetMapping("/mypage")
    public String testMypage(){return "/test/mypage-test";}


    @GetMapping("/mypage/chat")
    public String testChat(){return "/test/chat-test";}

    @GetMapping("/search")
    public String testSearch(){return "/test/search-test";}

    @GetMapping("/mypage-real")
    public String testMypageReal(){return "/test/mypage-test";}

    @GetMapping("/mypage-customer")
    public String testMypageCustomer(){return "/test/mypage-customer-test";}

}
