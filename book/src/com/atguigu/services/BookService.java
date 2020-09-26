package com.atguigu.services;

import com.atguigu.domain.Book;
import com.atguigu.domain.Page;

import java.util.List;

public interface BookService {
    public void add(Book book);


    public void deleteBookById(Integer id);


    public void update(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(Integer pageNo, Integer pageSize);

    Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max);
}
