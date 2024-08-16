package com.javaweb.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 17932
 * @date 2024/8/16 16:47
 * @description TODO
 */
// @WebServlet("/fileShow")
public class CharXmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String pathName = "WEB-INF/web.xml";
        String realPath = context.getRealPath(pathName);
        //System.out.println("realPath = " + realPath);
        resp.setContentType("text/xhtml;charset=utf-8");
        FileReader reader = new FileReader(realPath);
        PrintWriter writer = resp.getWriter();
        char[] chars = new char[1024];
        int len;
        while ((len = reader.read(chars)) != -1) {
            writer.write(chars, 0, len);
        }
    }
}
