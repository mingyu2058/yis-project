package com.service.yis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("")
    public String selectForm(){
        return "main/select";
    }

    @GetMapping("main")
    public String mainForm(){ return "main/main"};
}
