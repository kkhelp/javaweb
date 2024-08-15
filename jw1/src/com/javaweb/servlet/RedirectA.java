package com.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirecta")
public class RedirectA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RedirectA 执行了");
        String key = req.getParameter("key");
        System.out.println("RedirectA key = " + key);
        // 响应重定向 设置响应状态码为302 并且将响应头的localhost设置为redirectb
        //resp.sendRedirect("redirectb");
        // 重定向到homework2页面
        //resp.sendRedirect("page/homework2.html");
        // 重定向到外部地址
        resp.sendRedirect("https://baidu.com");
    }
}
