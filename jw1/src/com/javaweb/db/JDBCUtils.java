package com.javaweb.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;


public class JDBCUtils {
    private JDBCUtils() {}
    static DataSource dataSource;
    static {
        ClassLoader loader = JDBCUtils.class.getClassLoader();
        InputStream stream = loader.getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            // 加载配置文件
            properties.load(stream);
            // 数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取 dataSource
    public static DataSource getDataSource() {
        return dataSource;
    }
    // 获取数据库连接
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // 释放资源，还给数据库连接池
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
