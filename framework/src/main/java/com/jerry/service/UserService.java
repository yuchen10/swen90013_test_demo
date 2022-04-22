package com.jerry.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author yuchenli
 * @since 2022-04-13 21:05:58
 */
public interface UserService extends IService<User> {

    ResponseResult login(User user);

    ResponseResult logout();

    ResponseResult userInfo();

    ResponseResult register(User user);

    ResponseResult updateUserInfo(User user);
}


