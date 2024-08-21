package com.atguigu.delivery.listen;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * @author 17932
 * @date 2024/8/19 20:15
 * @description TODO
 */
// 使用注解声明监听器
//@WebListener
public class ListenDemo1 implements ServletContextListener, ServletContextAttributeListener {
    // 监听应用域属性的增加
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext context = scae.getServletContext();
        // 新增属性的属性名
        String name = scae.getName();
        // 新增属性的属性值
        Object value = scae.getValue();
        System.out.println(context.hashCode() + "应用域新增属性 " + name + "属性值" + value);
    }
    // 监听应用域属性的删除
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContext context = scae.getServletContext();
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println(context.hashCode() + "应用域属性的删除" + name + "属性值" + value);
    }
    // 监听应用域属性的修改
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContext context = scae.getServletContext();
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println(context.hashCode() + "应用域属性的修改" + name + "属性值" + value + "修改为：" + context.getAttribute(name));
    }
    // 监听应用域的初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println(context.hashCode() + "应用域的初始化");
    }
    // 监听应用域的销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println(context.hashCode() + "应用域的销毁");
    }
}
