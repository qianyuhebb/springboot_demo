package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.nio.channels.SeekableByteChannel;
import java.util.Map;

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
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username)&& "123456".equals(password)){
            session.setAttribute("loginUser",username);
           //为了防止表单重复提交，选择使用重定向
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或者密码错误");
            return "login";
        }


    }

}
