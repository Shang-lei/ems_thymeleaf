package com.sawyer.service;

import com.sawyer.entity.User;

public interface UserService {

    //注册
    void register(User user);

    //登录
    User login(String username, String password);
}
