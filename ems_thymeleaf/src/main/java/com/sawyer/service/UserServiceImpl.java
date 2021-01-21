package com.sawyer.service;

import com.sawyer.dao.UserDAO;
import com.sawyer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    //注册接口的实现
    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.save(user);
    }

    //登录接口的实现
    @Override
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}
