package com.javaweb.dao;

public interface UsersDao {
    boolean isLogin(String uname, String upwd);
    int addUser(String uname, String upwd);
}
