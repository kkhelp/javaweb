package com.jw2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 用来分发相同父路径下的请求
 * @author 17932
 * @date 2024/8/20 10:06
 * @description TODO
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Class<? extends BaseController> aClass = this.getClass();
        // 获取请求路径 路径最后的内容匹配方法名
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        // 获取方法名
        String methodName = split[split.length - 1];
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("方法[" + methodName + "]不存在");
        }

    }
}
