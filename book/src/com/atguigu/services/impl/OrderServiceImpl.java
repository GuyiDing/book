package com.atguigu.services.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.OrderDAO;
import com.atguigu.dao.OrderItemDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.dao.impl.OrderDAOImpl;
import com.atguigu.dao.impl.OrderItemDAOImpl;
import com.atguigu.domain.*;
import com.atguigu.services.OrderService;


import java.util.Date;
import java.util.List;

/**
 * @title: OrderServiceImpl
 * @Author liuxiankun
 * @Date: 2020/8/17 21:21
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public String createOrder(Integer userId, Car car) {
        String orderId = System.currentTimeMillis() + "" + userId;  //有特殊意义的订单号 唯一的
        //        保存订单(给管理员看的订单)
        orderDAO.saveOrder(new Order(orderId, new Date(), 0, car.getTotalPrice(), userId));
        //遍历订单数据获取其中的商品信息,并保存到详情订单中,即orderItem中
        for (CarItem item : car.getItems().values()) {
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId);
            //保存订单项
            orderItemDAO.saveOrderItem(orderItem);
//            int i = 12 / 0 ;
            //根据id更新图书库存等信息
            Book book = bookDAO.queryBookById(item.getId());

            book.setSales(book.getSales() + item.getCount());
            book.setStock(book.getStock() - item.getCount());
            bookDAO.update(book);
        }
//        下单后还要清空购物车
        car.clear();
        return orderId;
    }

    @Override
    public List<Order> queryMyOrders(Integer userId) {
        return orderDAO.queryOrdersByUserId(userId);
    }

    @Override
    public List<Order> queryOrders() {
        return orderDAO.queryOrders();
    }

    @Override
    public List<OrderItem> queryOrderItems(String orderId) {
        return orderItemDAO.queryOrderItems(orderId);
    }

    @Override
    public void sendOrder(String orderId) {
        orderDAO.sendOrder(orderId);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDAO.receiveOrder(orderId);
    }
}
