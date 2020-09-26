package com.atguigu.domain;

import java.util.List;

/**
 * @title: Page
 * @Author liuxiankun
 * @Date: 2020/8/14 10:14
 * @Version 1.0
 */
public class Page<T> {
    public static final Integer PAGE_SIZE = 4;//常量的表现形式
    private Integer pageNo; //当前页码
    private Integer pageSize = PAGE_SIZE; //每页显示的记录
    private Integer pageCount; //总记录数
    private Integer pageTotal; //总页数
    private List<Book> items; // 当前页数据
    private String url;

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", pageTotal=" + pageTotal +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Page() {
    }


}
