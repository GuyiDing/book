package com.atguigu.filter;

import com.atguigu.utils.JDBCToolsFinal;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req, resp);
            JDBCToolsFinal.commitAndClose();
        } catch (Exception e) {
            JDBCToolsFinal.rollbackAndClose();
            throw new RuntimeException(e);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
