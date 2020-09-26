package com.atguigu.dao;

import com.atguigu.domain.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItems(String orderId);
}
