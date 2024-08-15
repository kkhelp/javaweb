package com.javaweb.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 17932
 * @date 2024/8/15 20:45
 * @description TODO
 */
public class handQuery<T> {

    public T toClass(ResultSet resultSet, Class<T> clazz) {
        T t = null;
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            t = constructor.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(t, resultSet.getObject(field.getName()));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
}
