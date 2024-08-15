package com.javaweb.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author 17932
 * @date 2024/8/15 19:57
 * @description TODO
 */
public class JDBCUtils {
    private JDBCUtils() {}
    private static DataSource dataSource;
    static {
        //ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
        ClassLoader loader = JDBCUtils.class.getClassLoader();
        InputStream stream = loader.getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection, ResultSet resultSet){
        try {
            if (connection != null) {
                connection.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
