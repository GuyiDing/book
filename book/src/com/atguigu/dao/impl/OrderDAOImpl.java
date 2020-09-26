package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDAO;
import com.atguigu.domain.Order;
import com.atguigu.domain.OrderItem;
import com.atguigu.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @title: OrderDAOImpl
 * @Author liuxiankun
 * @Date: 2020/8/17 20:03
 * @Version 1.0
 */
public class OrderDAOImpl extends BaseDAOFinal implements OrderDAO {
    @Override
    public int saveOrder(Order order) { //用户下单之后创建一个订单并保存在数据库中
        String sql = "insert into t_order(`order_id`,`create_time`,`status`,`price`,`user_id`) values(?,?,?,?,?)";

        try {
            return update(sql, order.getOrderId(), order.getCreateTime(), order.getStatus(), order.getPrice(), order.getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) { //用户登录之后查询自己下的所有订单
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status` from t_order where user_id = ?";
        try {
            return getList(Order.class, sql, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int sendOrder(String orderId) {//管理员修改订单状态
        String sql = "update `t_order` set `status`= 1 where `order_id`=?";
        try {
            return update(sql, orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Order> queryOrders() { //查询所有订单
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order ";
        try {
            return getList(Order.class, sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int receiveOrder(String orderId) {
        String sql = "update `t_order` set `status`= 2 where `order_id`=?";
        try {
            update(sql, orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
