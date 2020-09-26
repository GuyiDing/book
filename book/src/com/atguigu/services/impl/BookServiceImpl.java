package com.atguigu.services.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.domain.Book;
import com.atguigu.domain.Page;
import com.atguigu.services.BookService;

import java.util.List;

/**
 * @title: BookServiceImpl
 * @Author liuxiankun
 * @Date: 2020/8/12 15:03
 * @Version 1.0
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = new BookDAOImpl();
    private Page<Book> page = new Page<>();

    @Override
    public void add(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {



        page.setPageSize(pageSize);
        Integer pageCount = bookDAO.queryForPageCount();
        page.setPageCount(pageCount);


        Integer pageTotal = pageCount / pageSize;
        page.setPageTotal(pageTotal);

        if (pageCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);  //必须得先有pageTotal


        Integer begin = (page.getPageNo() - 1) * page.getPageSize();
        List<Book> books = bookDAO.queryForPageItems(begin, page.getPageSize());

        page.setItems(books);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {


        page.setPageSize(pageSize);

        Integer pageCount = bookDAO.queryForPageCountByPrice(min,max);
        page.setPageCount(pageCount);


        Integer pageTotal = pageCount / pageSize;
        page.setPageTotal(pageTotal);

        if (pageCount % pageSize > 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);  //必须得先有pageTotal


        Integer begin = (page.getPageNo() - 1) * page.getPageSize();

        List<Book> books = bookDAO.queryForPageItemsByPrice(begin, page.getPageSize(),min,max);

        page.setItems(books);

        return page;
    }


}
