package com.javaweb.servlet;

import com.javaweb.dao.Impl.SysUserDaoImpl;
import com.javaweb.utils.MD5Utils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 17932
 * @date 2024/8/16 16:23
 * @description TODO
 */
@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String md5 = MD5Utils.md5(password);
        System.out.printf("userName = %s, password = %s, md5 = %s", userName, password, md5);
        int count = new SysUserDaoImpl().loginUser(userName, md5);
        resp.setContentType("text/html;charset=utf-8");
        if (count > 0) {
            resp.getWriter().write("登录成功");
        } else {
            resp.setStatus(500);
            resp.getWriter().write("登录失败");
        }
    }
}
