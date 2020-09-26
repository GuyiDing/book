package com.atguigu.services.impl;

import com.atguigu.dao.UserDAO;
import com.atguigu.domain.User;
import com.atguigu.dao.impl.UserDAOImpl;
import com.atguigu.services.UserService;

/**
 * @title: UserServiceImpl
 * @Author liuxiankun
 * @Date: 2020/8/7 20:52
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();


    @Override
    public void registUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User loginUser(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUser(String username) {
        User user = userDAO.queryUserByUserName(username);
        //没有该用户了, 可以添加了
        return user != null;//确实存在该用户,不可用
    }
}
