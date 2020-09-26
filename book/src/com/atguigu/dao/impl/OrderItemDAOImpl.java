package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDAO;
import com.atguigu.domain.OrderItem;

import java.sql.SQLException;
import java.util.List;

/**
 * @title: OrderItemDAOImpl
 * @Author liuxiankun
 * @Date: 2020/8/17 20:56
 * @Version 1.0
 */
public class OrderItemDAOImpl extends BaseDAOFinal implements OrderItemDAO {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`price`,`total_price`,`count`,`order_id`) values(?,?,?,?,?)";

        try {
            return update(sql, orderItem.getName(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getCount(), orderItem.getOrderId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }
    @Override
    public List<OrderItem> queryOrderItems(String orderId) {
        String sql = "select `id`,`name`,`count`,`price`,`total_price` totalPrice from t_order_item where order_id = ?";
        try {
            return getList(OrderItem.class,sql,orderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
