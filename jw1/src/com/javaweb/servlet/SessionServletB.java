package com.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 17932
 * @date 2024/8/16 22:00
 * @description TODO
 */
@WebServlet("/session2")
public class SessionServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session
        HttpSession session = req.getSession();
        System.out.println("session id = " + session.getId());
        System.out.println("是否是新的session " + session.isNew());
        // 获取session中的数据
        String name = (String) session.getAttribute("name");
        System.out.println("name = " + name);
    }
}
