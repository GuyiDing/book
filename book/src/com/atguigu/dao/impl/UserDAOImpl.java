package com.atguigu.dao.impl;


import com.atguigu.dao.UserDAO;
import com.atguigu.domain.User;

import java.sql.SQLException;

/**
 * @title: UserDAOImpl
 * @Author liuxiankun
 * @Date: 2020/8/7 18:51
 * @Version 1.0
 */
public class UserDAOImpl extends BaseDAOFinal implements UserDAO {

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select username ,password ,email,id from t_user where username = ? and password = ?";
        try {
            return getBean(User.class, sql, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user (`username`,password,email) value (?,?,?) ";
        try {
            return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public User queryUserByUserName(String username) {
        String sql = "select `username` ,`password`,`email` ,`id` from t_user where username = ? ";
        try {
            return getBean(User.class, sql, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
