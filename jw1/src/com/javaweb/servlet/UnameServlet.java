package com.javaweb.servlet;

import com.javaweb.dao.impl.UsersDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UnameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String uname = req.getParameter("uname");
        System.out.println("uname = " + uname);
        String info = "yes";
        if ("atguigu".equals(uname)) {
            info = "no";
        }
        resp.setContentType("text/html");
        resp.getWriter().write(info);
    }
}
