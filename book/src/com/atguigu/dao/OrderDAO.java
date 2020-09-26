package com.atguigu.dao;

import com.atguigu.domain.Order;
import com.atguigu.domain.User;

import java.util.List;

public interface OrderDAO {
    public int saveOrder(Order order);

    public List<Order> queryOrdersByUserId(Integer userId);

    public int sendOrder(String orderId);

    public List<Order> queryOrders();


    int receiveOrder(String orderId);
}
