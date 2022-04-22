package com.swen90013.controller;

import com.jerry.annotation.SystemLog;
import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.User;
import com.jerry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userInfo")
    public ResponseResult userInfo(){
        return userService.userInfo();
    }

    @PostMapping("/register")
    @SystemLog(businessName = "register new user")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }

    @PutMapping("/userInfo")
    public ResponseResult updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }
}
