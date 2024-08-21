package com.jw2.dao.impl;

import com.jw2.dao.BaseDao;
import com.jw2.dao.UserDao;
import com.jw2.entity.SysUser;

/**
 * @author 17932
 * @date 2024/8/20 15:01
 * @description TODO
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    // 登录
    public SysUser login(String username, String password) {
        String sql = "select count(1) from sys_user where username = ? and password = ?";
        return baseQuery(sql, SysUser.class, username, password);
    }
    @Override
    // 注册
    public int register(SysUser sysUser) {
        String sql = "insert into sys_user(username, password, nickname) values(?, ?, ?)";
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getPassword(), sysUser.getNickname());
    }
    @Override
    // 根据id查询用户
    public SysUser getUserById(Integer id) {
        String sql = "select id, username, password, nickname from sys_user where id = ?";
        return baseQuery(sql, SysUser.class, id);
    }
    @Override
    // 修改密码
    public int modifyPassword(Integer id, String oldPasd, String newPasd) {
        if (equalsPassword(id, oldPasd))
            return -1; // 原密码错误
        String sql = "update sys_user set password = ? where id = ? and password = ?";
        return baseUpdate(sql, newPasd, id, oldPasd);
    }
    public boolean equalsPassword(Integer id, String password) {
        String sql = "select password from sys_user where id = ?";
        SysUser sysUser = baseQuery(sql, SysUser.class, id);
        if (sysUser != null && sysUser.getPassword().equals(password))
            return true;
        return false;
    }
}
