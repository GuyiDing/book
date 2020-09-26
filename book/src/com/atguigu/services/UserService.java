package com.atguigu.services;

import com.atguigu.domain.User;

public interface UserService {
    //注册
    public void registUser(User user);

    //登录
    public User loginUser(User user);

    //检车用户名是否可用
    public boolean existUser(String username);
}
