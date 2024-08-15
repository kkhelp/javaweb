package com.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/relayb")
public class ServletRelayB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletRelayB执行力");
        String key = req.getParameter("key");
        System.out.println("key = " + key);
        /*RequestDispatcher dispatcher = req.getRequestDispatcher("");
        dispatcher.forward(req,resp);*/
    }
}
