package com.javaweb.dao.Impl;

import com.javaweb.dao.BaseDao;
import com.javaweb.dao.SysUserDao;
import com.javaweb.pojo.SysUser;
import com.javaweb.utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author 17932
 * @date 2024/8/15 22:30
 * @description TODO
 */
public class SysUserDaoImpl implements SysUserDao {
    private BaseDao baseDao = new BaseDao();

    /**
     * 用户注册
     * @param sysUser 用户对象
     * @return 返回0表示失败，1表示成功
     */
    @Override
    public int addUser(SysUser sysUser) {
        String sql = "insert into sys_user(nickname,password,username) values(?,?,?)";
        int count = baseDao.baseUpdate(JDBCUtils.getConnection(), sql, sysUser.getNickName(), sysUser.getPassword(), sysUser.getUserName());
        return count;
    }

    /**
     * 用户登录
     * @param userName 用户名
     * @param password 密码
     * @return 返回0表示失败，1表示成功
     */
    @Override
    public int loginUser(String userName, String password) {
        String sql = "select count(1) from sys_user where username = ? and password = ?";
        int count = baseDao.baseCountQuery(JDBCUtils.getConnection(), sql, userName, password);
        return count;
    }

    /**
     * 修改密码
     * @param id 用户id
     * @param oldPasd 原密码
     * @param newPasd 新密码
     * @return
     */
    public int modifyPassword(Integer id, String oldPasd, String newPasd) {
        String sql1 = "select password from sys_user where id = ?";
        List<SysUser> sysUsers = baseDao.baseQuery(JDBCUtils.getConnection(), sql1, SysUser.class, id);
        if (sysUsers.size() == 0) return 0;
        if (!oldPasd.equals(sysUsers.get(0).getPassword())) return 0;
        else {
            String sql2 = "update sys_user set password = ? where id = ?";
            int count2 = baseDao.baseUpdate(JDBCUtils.getConnection(), sql2, newPasd, id);
            return count2;
        }
    }
}
