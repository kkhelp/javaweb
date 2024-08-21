package com.atguigu.delivery.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author 17932
 * @date 2024/8/20 20:22
 * @description TODO
 */
@WebServlet("/delivery/*")
public class SysDeliveryController extends BaseController{
    protected void add(HttpServletRequest req, HttpServletResponse resp) {

    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) {}
    protected void modify(HttpServletRequest req, HttpServletResponse resp) {}
    protected void query(HttpServletRequest req, HttpServletResponse resp) {}
    protected void queryList(HttpServletRequest req, HttpServletResponse resp) {}
}
