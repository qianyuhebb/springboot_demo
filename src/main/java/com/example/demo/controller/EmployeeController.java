package com.example.demo.controller;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 时间：  2020/2/17
 * 创建者：  Administrator 钟文
 * 描述：
 * 参数：
 * 返回值：
 **/
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放入请求域中
        model.addAttribute("emps",employees);
        //thymeleaf会默认帮助拼接字符串  classpath：/templates/emps/list.html
        return "emps/list";
    }
}
