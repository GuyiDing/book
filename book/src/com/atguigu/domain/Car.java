package com.atguigu.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @title: Car
 * @Author liuxiankun
 * @Date: 2020/8/17 10:31
 * @Version 1.0
 */
public class Car {
    private Map<Integer, CarItem> items = new LinkedHashMap<>();

    @Override
    public String toString() {
        return "Car{" +
                "items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;

        //获取map中的所有value 并遍历
        for (CarItem value : items.values()) {
            totalCount += value.getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CarItem value : items.values()) {
            //累加商品价格
            totalPrice = totalPrice.add(value.getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CarItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CarItem> items) {
        this.items = items;
    }

    public void addItem(CarItem carItem) {
        CarItem item = items.get(carItem.getId()); //通过key查看是否已经存在该商品

        //如果bu存在
        if (item == null) {
            //则添加进去
            items.put(carItem.getId(), carItem); //以键值对的形式
        } else {
            //修改数量
            item.setCount(item.getCount() + 1);

            //别忘记了还要修改总金额
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void update(Integer id, Integer count) { //修改购物车商品数量
        CarItem carItem = items.get(id);
        if (carItem != null) {
            carItem.setCount(count);
            //同时还要修改总金额
            carItem.setTotalPrice(carItem.getPrice().multiply(new BigDecimal(carItem.getCount())));
        }
    }

    //清空购物车
    public void clear() {
        items.clear();
    }

}
