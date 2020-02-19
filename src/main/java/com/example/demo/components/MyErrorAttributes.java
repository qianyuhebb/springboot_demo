package com.example.demo.components;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 时间：  2020/2/19
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","guigu");
        //异常处理器携带的数据
        Map ext = (Map) webRequest.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }
}
