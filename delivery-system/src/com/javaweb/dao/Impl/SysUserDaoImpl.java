package com.javaweb.dao.Impl;

import com.javaweb.dao.BaseDao;
import com.javaweb.dao.SysUserDao;
import com.javaweb.pojo.SysUser;
import com.javaweb.utils.JDBCUtils;

/**
 * @author 17932
 * @date 2024/8/15 22:30
 * @description TODO
 */
public class SysUserDaoImpl implements SysUserDao {
    private BaseDao baseDao = new BaseDao();
    @Override
    public int addUser(SysUser sysUser) {
        String sql = "insert into sys_user(nickname,password,username) values(?,?,?)";
        int count = baseDao.baseUpdate(JDBCUtils.getConnection(), sql, sysUser.getNickName(), sysUser.getPassword(), sysUser.getUserName());
        return count;
    }

    @Override
    public int loginUser(String username, String password) {
        return 0;
    }

    @Override
    public int modifyPassword(Integer id, String password) {
        return 0;
    }
}
