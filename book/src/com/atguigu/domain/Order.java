package com.atguigu.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @title: Order
 * @Author liuxiankun
 * @Date: 2020/8/17 19:57
 * @Version 1.0
 */
public class Order {
    private String orderId;
    private Date createTime;
    private Integer status = 0; //未发货 / 已发货 / 已签收
    private BigDecimal price;
    private Integer userId;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Order() {
    }

    public Order(String orderId, Date createTime, Integer status, BigDecimal price, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.status = status;
        this.price = price;
        this.userId = userId;
    }
}
