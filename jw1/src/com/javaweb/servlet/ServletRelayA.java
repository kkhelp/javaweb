package com.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/relaya")
public class ServletRelayA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletRelayA执行力");
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        // 获取请求转发器，并转发给ServletRelayB
        //RequestDispatcher dispatcher = req.getRequestDispatcher("relayb");
        // 转发给项目下的页面
        //RequestDispatcher dispatcher = req.getRequestDispatcher("page/homework2.html");
        // 转发给WEB-INF下的页面。是唯一可以访问WEB-INF下文件的方式
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/error.html");
        dispatcher.forward(req,resp);
    }
}
