package com.jw2.dao;

import com.jw2.utils.EntityUtils;
import com.jw2.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作数据库的方法
 * @author 17932
 * @date 2024/8/20 10:06
 * @description TODO
 */
public class BaseDao {
    /**
     * 执行更新操作（增删改）
     * @param conn 数据库连接
     * @param sql sql语句
     * @param args 填充sql的参数
     * @return 返回更新数据的条数
     */
    public int baseUpdate(Connection conn, String sql, Object ...args) {
        int count = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            handleArgs(preparedStatement, args);
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return count;
    }
    public int baseUpdate(String sql, Object ...args) {
        return baseUpdate(JDBCUtils.getConnection(), sql, args);
    }

    /**
     * 获取查询数据的总条数
     * @param conn 数据库连接
     * @param sql sql语句
     * @param args 填充sql的参数
     * @return 返回查询数据的总条数
     */
    public int baseCountQuery(Connection conn, String sql, Object ...args) {
        int count = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            handleArgs(preparedStatement, args);
            count = preparedStatement.executeQuery().getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return count;
    }
    public int baseCountQuery(String sql, Object ...args) {
        return baseCountQuery(JDBCUtils.getConnection(), sql, args);
    }

    /**
     * 查询单条数据
     * @param conn 数据库连接
     * @param sql sql语句
     * @param clazz 转化的目标class对象
     * @param args 填充sql的参数
     * @return 返回查询的数据
     * @param <T> 返回的数据类型
     */
    public <T> T baseQuery(Connection conn, String sql, Class<T> clazz, Object ...args) {
        T t = null;
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            handleArgs(preparedStatement, args);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                t = new EntityUtils<T>().resultSetToEntity(resultSet, clazz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, resultSet);
        }
        return t;
    }
    public <T> T baseQuery(String sql, Class<T> clazz, Object ...args) {
        return baseQuery(JDBCUtils.getConnection(), sql, clazz, args);
    }

    /**
     * 查询多条数据
     * @param conn 数据库连接
     * @param sql sql语句
     * @param clazz 转化的目标class对象
     * @param args 填充sql的参数
     * @return 返回查询的数据的List集合
     * @param <T> 返回的数据类型
     */
    public <T> List<T> baseQuerys(Connection conn, String sql, Class<T> clazz, Object ...args) {
        List<T> list = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            handleArgs(preparedStatement, args);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new EntityUtils<T>().resultSetToEntity(resultSet, clazz));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, resultSet);
        }
        return list;
    }
    public <T> List<T> baseQuerys(String sql, Class<T> clazz, Object ...args) {
        return baseQuerys(JDBCUtils.getConnection(), sql, clazz, args);
    }

    private void handleArgs(PreparedStatement preparedStatement, Object ...args) {
        try {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
