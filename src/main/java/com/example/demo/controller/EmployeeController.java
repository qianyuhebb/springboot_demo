package com.example.demo.controller;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.net.idn.Punycode;

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

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放入请求域中
        model.addAttribute("emps",employees);
        //thymeleaf会默认帮助拼接字符串  classpath：/templates/emps/list.html
        return "emps/list";
    }

    @GetMapping("/emp")
    public String toAdd(Model model){

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";

    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("员工添加："+employee);
        employeeDao.save(employee);
        //重定向到员工列表页面
        return "redirect:/emps";

    }
    //先查询出员工信息，再进行页面数据回显
    @GetMapping("/emp/{id}")
    public  String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面，与新增页面重用 add.html 页面
        return "emps/add";

    }

    //需要提交id 作为参数
    @PutMapping("/emp")
    public  String updateEmployee(Employee employee){
        System.out.println("修改员工的数据："+employee);
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){

        employeeDao.delete(id);

        return "redirect:/emps";
    }

}
