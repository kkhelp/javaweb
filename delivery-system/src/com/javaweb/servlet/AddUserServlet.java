package com.javaweb.servlet;

import com.javaweb.dao.Impl.SysUserDaoImpl;
import com.javaweb.pojo.SysUser;
import com.javaweb.utils.MD5Utils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 17932
 * @date 2024/8/15 22:35
 * @description TODO
 */
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String nickName = req.getParameter("nickName");
        String s = MD5Utils.md5(password);
        SysUser sysUser = new SysUser(null, userName, s, nickName);
        SysUserDaoImpl sysUserDao = new SysUserDaoImpl();
        resp.setContentType("text/html;charset=utf-8");
        int count = sysUserDao.addUser(sysUser);
        if (count > 0) {
            resp.getWriter().write("注册成功");
        } else {
            resp.getWriter().write("注册失败");
        }
    }
}
