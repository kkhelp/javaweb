package com.atguigu.delivery.controller;

import com.atguigu.delivery.dao.Impl.SysUserDaoImpl;
import com.atguigu.delivery.dao.SysUserDao;
import com.atguigu.delivery.entity.SysUser;
import com.atguigu.delivery.utils.MD5Utils;
import com.atguigu.delivery.utils.ResponseObject;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 17932
 * @date 2024/8/16 19:43
 * @description TODO
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private SysUserDao sysUserDao = new SysUserDaoImpl();

    /**
     * 用户注册
     *
     * @param req  请求对象
     * @param resp 响应对象
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String nickName = req.getParameter("nickName");
        String s = MD5Utils.md5(password);
        SysUser sysUser = new SysUser(null, userName, s, nickName);
        resp.setContentType("text/html;charset=utf-8");
        int count = sysUserDao.addUser(sysUser);

        try {
            if (count > 0) {
                //resp.getWriter().write("注册成功");
                resp.sendRedirect("/login.jsp");
            } else {
                resp.setStatus(500);
                //resp.getWriter().write("注册失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("用户注册");
    }

    /**
     * 修改密码
     *
     * @param req  请求对象
     * @param resp 响应对象
     */
    protected void modify(HttpServletRequest req, HttpServletResponse resp) {
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        resp.setContentType("application/json;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = req.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("sysUser");
        try {
            PrintWriter writer = resp.getWriter();
            ResponseObject responseObject = new ResponseObject(500, null, null);
            if (session.isNew()) {
                responseObject.setMessage("请先登录");
            } else {
                int i = sysUserDao.modifyPassword(sysUser.getId(), MD5Utils.md5(oldPassword), MD5Utils.md5(newPassword));
                if (i == -1) {
                    responseObject.setMessage("原密码错误");
                } else if (i == 0) {
                    responseObject.setMessage("修改失败");
                } else if (i == 1) {
                    responseObject.setCode(200);
                    responseObject.setMessage("修改成功");
                    session.invalidate();
                    //SysUser userById = sysUserDao.getUserById(sysUser.getId());
                    //if (userById != null) session.setAttribute("sysUser", userById);
                }
            }
            writer.write(mapper.writeValueAsString(responseObject));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("修改密码");
    }

    /**
     * 用户登录
     *
     * @param req  请求对象
     * @param resp 响应对象
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) {


        /*String account = req.getParameter("account");
        String password = req.getParameter("password");
        List<SysUser> sysUsers = sysUserDao.loginUser(account, MD5Utils.md5(password));
        resp.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        try {
            if (sysUsers.size() > 0) {
                // 删除登录错误信息
                context.removeAttribute("loginError");
                // 获取session
                HttpSession session = req.getSession();
                // 设置session信息
                session.setAttribute("sysUser", sysUsers.get(0));

                // 重定向到index.jsp
                resp.sendRedirect("/index.jsp");
                //resp.getWriter().write("登录成功");
            } else {
                resp.setStatus(500);
                context.setAttribute("loginError", "登陆失败！");
                resp.sendRedirect("/login.jsp");
                //req.setAttribute("loginError", "登陆失败！");
                //req.getRequestDispatcher("/login.jsp").forward(req, resp);
                //resp.getWriter().write("登录失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        List<SysUser> sysUsers = sysUserDao.loginUser(userName, MD5Utils.md5(password));
        resp.setContentType("application/json;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();

        try {
            PrintWriter writer = resp.getWriter();
            if (sysUsers.size() > 0) {
                // 获取session
                HttpSession session = req.getSession();
                // 设置session信息
                session.setAttribute("sysUser", sysUsers.get(0));
                // 登录成功直接重定向
                //resp.sendRedirect("/index.jsp");
                writer.write(mapper.writeValueAsString(new ResponseObject(200, "登陆成功", null)));
            } else {
                writer.write(mapper.writeValueAsString(new ResponseObject(500, "登陆失败", null)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* try (BufferedReader reader = req.getReader()) {
            // 接收JDON格式的请求参数
            char[] chars = new char[1024];
            int len;
            StringBuilder obj = new StringBuilder();
            while ((len = reader.read(chars)) != -1) {
                obj.append(chars, 0, len);
            }
            ObjectMapper mapper = new ObjectMapper();
            // 将JSON转化成class对象
            SysUser sysUser = mapper.readValue(obj.toString(), SysUser.class);
            List<SysUser> sysUsers = sysUserDao.loginUser(sysUser.getUserName(), MD5Utils.md5(sysUser.getPassword()));
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            String json = "";

            if (sysUsers.size() > 0) {
                // 获取session
                HttpSession session = req.getSession();
                // 设置session信息
                session.setAttribute("sysUser", sysUsers.get(0));
                // 响应信息对象转成json
                json = mapper.writeValueAsString(new ResponseObject(200, "登陆成功", sysUsers.get(0)));
            } else {
                json = mapper.writeValueAsString(new ResponseObject(500, "登陆失败", null));
            }
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 退出登录
     *
     * @param req
     * @param resp
     */
    protected void back(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            // 退出登录, 清空session
            session.invalidate();
            resp.sendRedirect("/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
