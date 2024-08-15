package com.javaweb.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String key1 = context.getInitParameter("contextA");
        System.out.println("contextA = " + key1);
        // 获取key值 相当于 iterator
        Enumeration<String> enumeration = context.getInitParameterNames();
        // 先判断是否有下一个key，然后在根据key获取值
        while (enumeration.hasMoreElements()) {
            String nextElement = enumeration.nextElement();
            System.out.println(nextElement + " = " + context.getInitParameter(nextElement));
        }
        context.setAttribute("name", "张三");
    }
}
