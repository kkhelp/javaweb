package com.javaweb.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author 17932
 * @date 2024/8/16 19:43
 * @description TODO
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    /**
     * 用户注册
     * @param req 请求对象
     * @param resp 响应对象
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("用户注册");
    }

    /**
     * 修改密码
     * @param req 请求对象
     * @param resp 响应对象
     */
    protected void modify(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("修改密码");
    }

    /**
     * 用户登录
     * @param req 请求对象
     * @param resp 响应对象
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("用户登录");
    }
}
