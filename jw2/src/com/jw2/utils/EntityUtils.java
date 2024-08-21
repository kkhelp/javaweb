package com.jw2.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * 用于处理Entity类的工具类 将Entity类中的属性名转换为数据库中的字段名
 * @author 17932
 * @date 2024/8/20 9:16
 * @description TODO
 */
public class EntityUtils<T> {
    public T resultSetToEntity(ResultSet resultSet, Class<T> clazz) {
        Constructor<T> constructor = null;
        T t = null;
        try {
            // 获取无参构造器
            constructor = clazz.getDeclaredConstructor();
            // 创建对象
            t = constructor.newInstance();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i + 1);
                // 如果字段名与数据库中的字段名相同，则将数据库中的字段值赋给实体类的属性
                Field field = null;
                try {
                    field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, resultSet.getObject(columnLabel));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                    System.out.println(clazz + "中，字段名" + columnLabel + "不存在");
                }
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
}
