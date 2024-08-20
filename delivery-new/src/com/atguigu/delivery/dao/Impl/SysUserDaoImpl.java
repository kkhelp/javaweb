package com.atguigu.delivery.dao.Impl;

import com.atguigu.delivery.dao.BaseDao;
import com.atguigu.delivery.dao.SysUserDao;
import com.atguigu.delivery.entity.SysUser;
import com.atguigu.delivery.utils.JDBCUtils;

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
    public List<SysUser> loginUser(String userName, String password) {
        String sql = "select id,username userName,password,nickname nickName from sys_user where username = ? and password = ?";
        List<SysUser> sysUsers = baseDao.baseQuery(JDBCUtils.getConnection(), sql, SysUser.class, userName, password);
        return sysUsers;
    }

    public SysUser getUserById(Integer id) {
        String sql = "select id,username userName,password,nickname nickName from sys_user where id = ?";
        List<SysUser> sysUsers = baseDao.baseQuery(JDBCUtils.getConnection(), sql, SysUser.class, id);
        return sysUsers.size() == 0 ? null : sysUsers.get(0);
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
        // 查询原密码
        List<SysUser> sysUsers = baseDao.baseQuery(JDBCUtils.getConnection(), sql1, SysUser.class, id);
        if (sysUsers.size() == 0) return 0;
        // 与原密码不符合
        if (!oldPasd.equals(sysUsers.get(0).getPassword())) return -1;
        else {
            String sql2 = "update sys_user set password = ? where id = ?";
            int count2 = baseDao.baseUpdate(JDBCUtils.getConnection(), sql2, newPasd, id);
            return count2;
        }
    }
}
