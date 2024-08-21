package com.atguigu.delivery.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 17932
 * @date 2024/8/19 19:28
 * @description TODO
 */
// 配置过滤器的过滤器路径，会过滤符合条件的请求 /* 表示匹配所有请求
//@WebFilter({"/user/add", "/user/modify", "/user/back"})
@WebFilter(value = "/user/*", initParams = { @WebInitParam(name = "key1", value = "123") })

public class FilterDemo1 implements Filter {
    // 项目启动时执行，只执行一次
    public FilterDemo1() {
        System.out.println("过滤器 FilterDemo1 构造");
    }
    // 项目启动时在过滤器构之后执行，只执行一次
    // filterConfig表示过滤器配置对象 可配置一些初始化数据，键值对形式
    public void init(FilterConfig filterConfig) throws ServletException {
        // 过滤器的全路径名称
        String filterName = filterConfig.getFilterName();
        System.out.println("filterName = " + filterName);
        // 获取配置的初始化数据
        String key1 = filterConfig.getInitParameter("key1");
        System.out.println("key1 = " + key1);
        System.out.println("过滤器 FilterDemo1 初始化");
    }
    // 每次请求时执行
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 可以直接 父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 放行请求之前的代码
        System.out.println("放行请求之前的代码");

        HttpSession session = request.getSession();
        String id = session.getId();
        boolean aNew = session.isNew();
        System.out.println("id = " + id);
        System.out.println("aNew = " + aNew);

        /*HttpSession session = request.getSession(false);
        System.out.println("session = " + session);*/

        long l = System.currentTimeMillis();

        /*if (session == null) {
            response.sendRedirect("/login.jsp");
            //response.setContentType("text/html;charset=utf-8");
            //response.getWriter().write("请先登录");
        } else
            filterChain.doFilter(request, response);*/

        /*if (session != null) {
            // 放行请求
            filterChain.doFilter(request, response);
        } else
            response.sendRedirect("/login.jsp");*/

        long l1 = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        System.out.println("servlet处理请求，耗时：" + (l1 - l));
        // 放行请求之后的代码
        System.out.println("放行请求之后的代码");
    }
    // 项目关闭时销毁
    public void destroy() {
        System.out.println("过滤器 FilterDemo1 销毁");
    }
}
