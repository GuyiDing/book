package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
本版本升级的是从数据库连接池中获取连接
强调：druid.properties中的key名字不能随便写，得和DruidDataSource的属性名一样：
        //(2)设置基本参数
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setUsername("root");
        ds.setPassword("123456");
        //(3)设置高级参数
        ds.setInitialSize(5);
        ds.setMaxActive(20);
        ds.setMaxWait(1000);
 */
public class JDBCToolsFinal {
    private static DataSource dataSource;//数据源，也称为连接池
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCToolsFinal.class.getClassLoader().getResourceAsStream("JDBC.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
   只要同一个线程对象来调用这个getConnection()方法，那么就一定能得到同一个Connection对象
    */
    public static Connection getConnection() throws SQLException {
        //每次都从MySQL获取一个新的连接对象
//        return DriverManager.getConnection(url,username,password);

        //先从当前线程的map中找一下有没有threadLocal对应的连接对象
        Connection connection = threadLocal.get();
        //如果没有，就从服务器获取一个新的
        if (connection == null) {
            connection = dataSource.getConnection();

            //开启手动提交事务模式
            connection.setAutoCommit(false);

            //存储到当前线程的map中
            threadLocal.set(connection);
        }
        return connection;
    }

    //接下来就要分两种情况关闭链接  提交(commit)之后关闭链接以及回滚(rollback)之后关闭链接
    public static void commitAndClose() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.commit();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //需要彻底删除线程中的数据
        threadLocal.remove();
    }

    public static void rollbackAndClose() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        threadLocal.remove();
    }
}
