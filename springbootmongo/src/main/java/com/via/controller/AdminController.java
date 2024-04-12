package com.via.controller;

import com.via.common.Result;
import com.via.entity.Params;
import com.via.entity.Users;
import com.via.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

//    // 测试MongoDB连接
//    @Autowired
//    private MongoConnectionTestService mongoConnectionTestService;
//
//    @GetMapping("/checkMongoConnection")
//    public boolean checkMongoConnection() {
//        return mongoConnectionTestService.testConnection();
//    }

    @Resource
    private AdminService adminservice;

    // 列出所有用户
    @GetMapping("/getUser")
    public Result getUser() {
        List<Users> list = adminservice.getUser();
        return Result.success(list);
    }

    // 查询用户
    @GetMapping("/searchUser")
    public Result searchUser(Params params) {
        List<Users> list = adminservice.findBy(params);
        return Result.success(list);
    }

    // 添加用户
    @PostMapping("/addUser")
    public Result addUser(@RequestBody Users user) {
        Users savedUser = adminservice.addUser(user);
        if (savedUser != null) {
            return Result.success(savedUser);
        } else {
            return Result.error();
        }
    }

    // 分页查询
    @GetMapping("/getUserPage")
    public Result getUserPage(Pageable pageable) {
        Page<Users> page = adminservice.getUserPage(pageable);
        return Result.success(page);
    }

}