package com.service.yis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Controller
@RequestMapping("/tradeRegister")
@RequiredArgsConstructor
public class TradeRegister {

    @GetMapping
    public String tradeRegisterMain(){
        return "tradeRegister/trade_register";
    }

	@RequestMapping(value = "productRegister.do", method = RequestMethod.POST)
	@ResponseBody
    public Object productRegister() {
        int is_register = data_Center_Service.getItem();
        return list;
    }
}
