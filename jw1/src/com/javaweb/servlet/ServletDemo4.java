package com.javaweb.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/demo4")
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        // 获取项目在硬盘上的绝对路径
        String dao = context.getRealPath("dao");
        System.out.println("dao = " + dao);
        // 获取项目在服务器上的访问路径
        // 获取当前上下文的路径
        String path = context.getContextPath(); // /jw1
        System.out.println("path = " + path);
        Object name = context.getAttribute("name");
        System.out.println("name = " + name);
        // resp.setHeader("Content-Length", "132");
    }
}
