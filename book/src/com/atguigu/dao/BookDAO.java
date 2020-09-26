package com.atguigu.dao;

import com.atguigu.domain.Book;

import java.util.List;

public interface BookDAO {
    //保存图书信息
    public int saveBook(Book book);

    //修改图书
    public int update(Book book);

    //删除图书(根据ID)
    public int deleteBookById(Integer id);

    //查询图书(根据图书id)
    public Book queryBookById(Integer id);

    //查询所有图书
    public List<Book> queryBooks();

    //查询page页面对象总记录数
    Integer queryForPageCount();

    //查询当前页面数据
    List<Book> queryForPageItems(Integer begin, Integer pageSize);


    Integer queryForPageCountByPrice(Integer min, Integer max);

    List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max);
}
