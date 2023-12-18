package com.krxk.backend.controller;


import com.krxk.backend.entity.User;
import com.krxk.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/user")
    public String InsertUser(User user) { // 用于注册用户
        int res = userMapper.insert(user);
        if(res > 0) {
            return "用户注册成功";
        } else {
            return "用户注册失败";
        }
    }

    @GetMapping("/user")
    public String  LoginUser(int id, String password) { // 用户登录
        User user = userMapper.selectById(id);
        if (user.getPassword().equals(password)) {
            return "登录成功";
        } else {
            return "登录失败";
        }
    }
}
