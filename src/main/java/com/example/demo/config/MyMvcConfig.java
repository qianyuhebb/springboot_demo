package com.example.demo.config;

import com.example.demo.components.LoginHandlerIntercepter;
import com.example.demo.components.MyLocalResolve;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 时间：  2020/2/16
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public  void addViewControllers(ViewControllerRegistry registry){
         registry.addRedirectViewController("/atguigu","success");

    }

    @Bean  //注册组件
    public  WebMvcConfigurerAdapter webMvcConfigurerAdapter(){

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {


            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");

            }
            //配置拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源，springboot已经帮我们做好了处理  2.0以上会有影响
                registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/bootstrap/**");
            }
        };
        return adapter;
    }

    @Bean  //自定义国际化解析
     public LocaleResolver localeResolver(){
        return new MyLocalResolve();
     }



}
