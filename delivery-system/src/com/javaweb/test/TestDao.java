package com.javaweb.test;

import com.javaweb.dao.BaseDao;
import com.javaweb.pojo.SysUser;
import com.javaweb.utils.JDBCUtils;
import org.junit.AfterClass;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author 17932
 * @date 2024/8/15 20:47
 * @description TODO
 */
public class TestDao {
    static Connection conn;
    @AfterClass
    public static void connTest() {
        conn = JDBCUtils.getConnection();
    }
    @Test
    public void m1() {
        String sql = "select id,username userName,password,nickname nickName from sys_user";
        BaseDao baseDao = new BaseDao();
        List<SysUser> sysUsers = baseDao.baseQuery(conn, sql, SysUser.class);
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser);
        }
    }

    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select id,username userName,password,nickname nickName from sys_user";
        BaseDao baseDao = new BaseDao();
        List<SysUser> sysUsers = baseDao.baseQuery(connection, sql, SysUser.class);
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser);
        }
    }
}
