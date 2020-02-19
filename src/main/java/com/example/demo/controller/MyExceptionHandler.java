package com.example.demo.controller;

import com.example.demo.UserNotExiestException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间：  2020/2/19
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
@ControllerAdvice
public class MyExceptionHandler  {


    //浏览器和其他的客户端返回的都是json数据
  /*  @ResponseBody
    @ExceptionHandler(UserNotExiestException.class)
    public Map<String,Object> handlerException(Exception e){

        Map<String,Object> map = new HashMap<>();
        map.put("code","5xx");
        map.put("message",e.getMessage());
        return map;
    }*/


    @ExceptionHandler(UserNotExiestException.class)
    public String handlerException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","400");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
