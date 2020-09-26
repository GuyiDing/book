package com.atguigu.services;

import com.atguigu.domain.Car;

import com.atguigu.domain.Order;
import com.atguigu.domain.OrderItem;


import java.util.List;

/**
 * @title: OrderService
 * @Author liuxiankun
 * @Date: 2020/8/17 21:19
 * @Version 1.0
 */
public interface OrderService {
    //生成订单
    public String createOrder(Integer userId, Car car);

    public List<Order> queryMyOrders(Integer userId);

    public List<Order> queryOrders();

    public List<OrderItem> queryOrderItems(String orderId);


    void sendOrder(String orderId);

    void receiveOrder(String orderId);
}
