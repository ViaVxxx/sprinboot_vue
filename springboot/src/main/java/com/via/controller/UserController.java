package com.via.controller;

import com.via.entity.User;
import com.via.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //RestController的作用是将返回的数据直接显示在页面上
@RequestMapping("/user") //RequestMapping的作用是指定url
public class UserController {

//  controller层的作用是接收前端的请求，然后调用service层的方法，最后返回数据给前端
//  可以在这个方法上再加上一个url，比如@GetMapping("/start")
//  也可以指定请求方式：GET、POST、PUT、DELETE等，增删改查。


//  这样在浏览器上输入http://localhost:8080/user/start就可以访问到这个方法

//  @GetMapping("/start") 是一个get请求，表示访问这个方法的时候需要在url上加上/start
//  @return 是返回给前端的数据

//  http://localhost:8080/{'@RequestMapping'}/{'@GetMapping'}

    @Resource
    private UserService userservice;


    @GetMapping("/start")
    public String start() {
        return "This is your Spring Boot application!";
    }

    @GetMapping("/getUser")
    public List<User> getUser() {
        return userservice.getUser();
    }



}
