package com.atguigu.dao;

import com.atguigu.domain.User;

public interface UserDAO {

    //根据用户名和密码查询用户
    public User queryUserByUsernameAndPassword(String username,String password);



    //保存用户信息
    public int saveUser(User user);



    //根据用户名查询用户
    public User queryUserByUserName(String username);


}
