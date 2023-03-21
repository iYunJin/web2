package com.twt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *快速入门
 */
@WebFilter("/*")//访问所有资源之前都会执行该过滤器
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo2被执行了");

        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filterDemo2回来了");
    }
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
