package com.javaweb.servlet;

import com.javaweb.dao.impl.UsersDaoImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        System.out.printf("%s, %s\n", userName, password);
        resp.setContentType("text/html");
        //resp.setCharacterEncoding("UTF-8");
        //resp.setContentType("text/html;charset=UTF-8");
        if ("abc123".equals(userName) && "abc123".equals(password)) {
            resp.getWriter().write("登录成功");
        } else {
            resp.getWriter().write("登录失败");
        }
    }
}

/**
 * import java.util.HashMap;
 * import java.util.Map;
 *
 * public class UserLogin {
 *
 *     private Map<String, String> userCredentials = new HashMap<>();
 *
 *     public UserLogin() {
 *         // 初始化一些用户凭证，实际应从数据库获取
 *         userCredentials.put("user1", "pass1");
 *         userCredentials.put("user2", "pass2");
 *     }
 *
 *     public boolean login(String username, String password) {
 *         // 检查用户名是否存在
 *         if (!userCredentials.containsKey(username)) {
 *             return false;
 *         }
 *
 *         // 检查密码是否匹配
 *         if (!userCredentials.get(username).equals(password)) {
 *             return false;
 *         }
 *
 *         return true;
 *     }
 *
 *     public static void main(String[] args) {
 *         UserLogin login = new UserLogin();
 *         boolean result = login.login("user1", "pass1");
 *         if (result) {
 *             System.out.println("登录成功");
 *         } else {
 *             System.out.println("登录失败，用户名或密码错误");
 *         }
 *     }
 * }
 */
