package com.atguigu.delivery.dao;

import com.atguigu.delivery.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 17932
 * @date 2024/8/15 20:01
 * @description TODO
 */
public class BaseDao {
    public <T> List<T> baseQuery(Connection conn, String sql, Class<T> clazz, Object ...args) {
        if (conn == null)
            throw new RuntimeException("数据库连接对象不能为空");
        List<T> list = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            setArgs(statement,args);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new handQuery<T>().toClass(resultSet, clazz));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, resultSet);
        }
        return list;
    }

    /**
     * 查询数量的sql语句
     * @param conn 数据库连接对象
     * @param sql sql语句
     * @param args 填充sql的参数
     * @return 执行查询语句后返回的记录数
     */
    public int baseCountQuery(Connection conn, String sql, Object ...args) {
        if (conn == null)
            throw new RuntimeException("数据库连接对象不能为空");
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            setArgs(statement,args);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, resultSet);
        }
        return 0;
    }

    /**
     * 更新数据库
     * @param conn 数据库连接对象
     * @param sql sql语句
     * @param args 填充sql的参数
     * @return 执行sql语句后返回受影响的行数
     */
    public int baseUpdate(Connection conn, String sql, Object ...args) {
        if (conn == null)
            throw new RuntimeException("数据库连接对象不能为空");
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            setArgs(statement,args);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return 0;
    }

    /**
     * 公共的设置sql参数的方法
     * @param statement PreparedStatement对象
     * @param params 填充sql的参数
     * @throws SQLException
     */
    private void setArgs(PreparedStatement statement, Object ...params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i+1,params[i]);
        }
    }
}
