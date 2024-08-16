package com.javaweb.servlet;

import com.javaweb.dao.Impl.SysUserDaoImpl;
import com.javaweb.utils.MD5Utils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 17932
 * @date 2024/8/16 18:29
 * @description TODO
 */
@WebServlet(value = "/modifyPasd", initParams = { @WebInitParam(name = "id", value = "6") })
public class ModifyPasdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null || id.length() == 0)
            id = getInitParameter("id");
        String oldPasd = MD5Utils.md5(req.getParameter("oldPasd"));
        String newPasd = MD5Utils.md5(req.getParameter("newPasd"));
        System.out.printf("%s, %s, %s", id, oldPasd, newPasd);
        int count = 0;
        try {
            count = new SysUserDaoImpl().modifyPassword(Integer.parseInt(id), oldPasd, newPasd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (count > 0) {
            writer.write("修改成功");
        } else {
            resp.setStatus(500);
            writer.write("修改失败");
        }
    }
}
