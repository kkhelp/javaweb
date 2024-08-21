package com.jw2.controller;

import com.jw2.dao.SysStoryDao;
import com.jw2.dao.impl.SysStoryDaoImpl;
import com.jw2.entity.SysStory;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * @author 17932
 * @date 2024/8/20 18:56
 * @description TODO
 */
@WebServlet("/story/*")
public class SysStoryController extends BaseController {
    SysStoryDao sysStoryDao = new SysStoryDaoImpl();
    protected void getStoryById(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        SysStory story = sysStoryDao.getStoryById(Integer.parseInt(id));
        resp.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter writer = resp.getWriter();
            writer.write(story.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
