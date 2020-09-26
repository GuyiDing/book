package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @title: WebUtils
 * @Author LiuXianKun
 * @Date: 2020/8/11 19:10
 * @Version 1.0
 */
public class WebUtils {
    //<T>确定返回值类型
    public static <T> T copyParamToBean(T bean , Map params){
        try {
            BeanUtils.populate(bean,params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }


    public static Integer parseInt(String intStr, Integer defaultValue) {
        try {
            return Integer.parseInt(intStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;

    }
}
