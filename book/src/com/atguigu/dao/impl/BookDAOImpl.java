package com.atguigu.dao.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.domain.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * @title: BookDAOImpl
 * @Author liuxiankun
 * @Date: 2020/8/12 10:16
 * @Version 1.0
 */
public class BookDAOImpl extends BaseDAOFinal implements BookDAO {
    @Override
    public int saveBook(Book book) {
        String sql = "insert into t_book(name, author, price, sales, stock , img_path) values(?,?,?,?,?,?)";
        try {
            return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(Book book) {
        String sql = "update t_book set `name` =?, `author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";

        try {
            return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";

        try {
            return update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path`  imgPath,`id` from t_book where id = ?";
        try {
            return getBean(Book.class, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path`  imgPath,`id` from t_book";
        try {
            return getList(Book.class, sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer queryForPageCount() {
        String sql = "select count(*) from t_book;";
        Object count = null;
        try {
            count = getValue(sql);
            return new Integer(count.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Book> queryForPageItems(Integer begin, Integer pageSize) {
        String sql = "select `name`, `author`,`price`,`sales`,`stock`,`img_path` imgPath,`id` from t_book limit ? , ?";
        try {
            return getList(Book.class,sql,begin,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer queryForPageCountByPrice(Integer min, Integer max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Object count = null;
        try {
            count = getValue(sql,min,max);
            return new Integer(count.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max) {
        String sql = "select `name`, `author`,`price`,`sales`,`stock`,`img_path` imgPath,`id` from t_book where price between ? and ? order by price limit ? , ?";
        try {
            return getList(Book.class,sql,min,max,begin,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
