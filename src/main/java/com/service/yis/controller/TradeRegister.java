package com.service.yis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tradeRegister")
@RequiredArgsConstructor
public class TradeRegister {

    @GetMapping
    public String tradeRegisterMain(){
        return "tradeRegister/trade_register";
    }

}
