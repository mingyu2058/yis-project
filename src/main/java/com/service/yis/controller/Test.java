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
    public String crowdFundingMain(){
        return "/test/main-test";
    }

    @GetMapping("/login")
    public String test(){
        return "/test/login-test";
    }
}
