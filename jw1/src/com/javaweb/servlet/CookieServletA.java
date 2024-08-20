package com.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 17932
 * @date 2024/8/16 20:58
 * @description TODO
 */
@WebServlet("/cookie1")
public class CookieServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取cokie对象并赋值
        Cookie cookie1 = new Cookie("name", "zhangsan");
        // 设置cookie1的时效，在失效时间内，即使关闭浏览器，cookie1也不会消失
        //cookie1.setMaxAge(60 * 5);
        // 设置cookie的请求路径，只有/demo1可以携带cookie1
        cookie1.setPath("/demo1");
        Cookie cookie2 = new Cookie("age", "18");
        // 给响应添加cookie
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
