package com.swen90013.controller;

import com.jerry.AppHttpCodeEnum;
import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.User;
import com.jerry.exception.SystemException;
import com.jerry.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Login Controller", tags = { "login demo" })
public class LoginController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "login user SWEN90013 DEMO")
    @ApiResponses(value = { @ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, response = ResponseResult.class,message = "xxxx") })
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return userService.login(user);
    }
    @ApiOperation(value = "logout user SWEN90013 DEMO")
    @PostMapping("/logout")
    public ResponseResult logout() {

        return userService.logout();
    }
}
