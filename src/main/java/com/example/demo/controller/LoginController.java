package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 时间：  2020/2/16
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
@Controller()
public class LoginController {


//    @RequestMapping(value = "/user/login" ,method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(){

        return "dashboard";
    }

}
