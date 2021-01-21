package com.sawyer.dao;

import com.sawyer.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    //用户注册的信息保存
    void save(User user);

    //用户登录的方法声名
    //在mybatis中传递多个参数需要参数的绑定
    User login(@Param("username") String username, @Param("password") String password);
}
