package com.javaweb.dao.impl;

import com.javaweb.dao.UsersDao;
import com.javaweb.db.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoImpl implements UsersDao {
    @Override
    public boolean isLogin(String uname, String upwd) {
        String sql = "select count(1) from users where username = ? and password = ?";
        Connection conn = JDBCUtils.getConnection();
        boolean isFlag = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, uname);
            ps.setObject(2, upwd);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                isFlag = resultSet.getInt(1) == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isFlag;
    }

    @Override
    public int addUser(String uname, String upwd) {
        String sql = "insert into users(username,password) values(?,?)";

        return 0;
    }
}
