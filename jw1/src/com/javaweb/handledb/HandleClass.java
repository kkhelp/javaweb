package com.javaweb.handledb;

import org.apache.commons.dbutils.ResultSetHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class HandleClass<R> {
    public R handleResultSet(ResultSet resultSet, String className) {
        R result = null;
        try {
            Class<R> clazz = (Class<R>) Class.forName(className);
            Constructor<R> constructor = clazz.getDeclaredConstructor();
            result = constructor.newInstance();
            Field[] fields = clazz.getDeclaredFields();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int count = metaData.getColumnCount();
            for (int i = 0; i < count; i++) {
                String label = metaData.getColumnLabel(i + 1);
                System.out.printf("%s\t", label);
            }

            for (Field field : fields) {
                field.setAccessible(true);

                System.out.println(field.getName());

                Object data = resultSet.getObject(field.getName());
                field.set(result, data);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
