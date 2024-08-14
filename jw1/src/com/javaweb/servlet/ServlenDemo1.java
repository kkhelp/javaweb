package com.javaweb.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * value 使用注解配置路径
 * loadOnStartup默认值是-1 表示服务启动时不执行
 * loadOnStartup 值越小，优先级越高
 */
//@WebServlet(value = "/demo1", loadOnStartup = 10)
public class ServlenDemo1 extends HttpServlet {
    public void ServlenLifeCycle() {
        System.out.println("实例化");
    }
    public void init() {
        System.out.println("初始化");
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("服务");
    }
    public void destroy() {
        System.out.println("销毁");
    }
}
