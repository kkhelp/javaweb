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
@WebServlet("/session1")
public class SessionServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        /**
         * 获取session
         * 1.如果session不存在，则创建一个session
         * 2.如果session存在，则获取session；如果session没找到，则创建一个session；如果session找到了，则返回session
         */
        HttpSession session = req.getSession();
        // 获取session的id
        System.out.println("session id = " + session.getId());
        // 获取session的最大存活时间 默认是30分钟 默认的配置在tomcat的web.xml中
        // 也可在当前项目下的web.xml中配置
        // <session-config>
        //     <session-timeout>30</session-timeout>
        // </session-config>
        // 或者在代码中设置，通过session.setMaxInactiveInterval(30); 入参单位是秒
        System.out.println("session maxInactiveInterval = " + session.getMaxInactiveInterval());
        // 判断session是否是新创建的
        System.out.println("session isNew = " + session.isNew());
        // 将数据name存储到session中
        session.setAttribute("name", name);
    }
}
