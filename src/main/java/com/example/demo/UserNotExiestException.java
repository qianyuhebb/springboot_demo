package com.example.demo;

/**
 * 时间：  2020/2/19
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
public class UserNotExiestException extends  RuntimeException {

    public UserNotExiestException() {
        super("用户不存在");
    }
}
