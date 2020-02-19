package com.example.demo.controller;

import com.example.demo.UserNotExiestException;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * 时间：  2020/2/14
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
@Controller
public class test {


    /*@RequestMapping({"/","login.html"})
    public String index(){
        System.out.println("index跳转");
        return "index";
    }*/


    @RequestMapping("/hello")
    @ResponseBody
    public String test(@RequestParam("user") String user){

        if (user.equals("aaa")){
            throw new UserNotExiestException();
        }
        return "hello word";
    }

    @RequestMapping("/success")
    public  String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","list","wangwu"));
        //thymleaf模板引擎会自动找classpath:/template/success.html
        return "success";
    }
}
