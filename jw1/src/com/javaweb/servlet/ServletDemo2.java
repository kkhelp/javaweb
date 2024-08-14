package com.javaweb.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 通过注解的方式配置ServletConfig
 */
/*@WebServlet(value = "/demo2", initParams = {@WebInitParam(name = "key1", value = "value1"),
        @WebInitParam(name = "key2", value = "value2")})*/
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String key1 = config.getInitParameter("key1");
        System.out.println("key1 = " + key1);
        // 获取key值 相当于 iterator
        Enumeration<String> enumeration = config.getInitParameterNames();
        // 先判断是否有下一个key，然后在根据key获取值
        while (enumeration.hasMoreElements()) {
            String nextElement = enumeration.nextElement();
            System.out.println(nextElement + " = " + config.getInitParameter(nextElement));
        }
    }
}
