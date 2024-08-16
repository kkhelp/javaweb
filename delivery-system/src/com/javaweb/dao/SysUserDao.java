package com.javaweb.dao;

import com.javaweb.pojo.SysUser;

/**
 * 用户Dao
 * @author 17932
 * @date 2024/8/15 19:35
 * @description TODO
 */
public interface SysUserDao {
    /**
     * 用户注册
     * @param sysUser 用户对象
     * @return 返回搜影响行数 为0表示添加失败 大于0表示添加成功
     */
    int addUser(SysUser sysUser);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 返回搜影响行数 为0表示登录失败 大于0表示登录成功
     */
    int loginUser(String username,String password);
    /**
     * 修改密码，先判断原密码是否正确，正确才修改修改
     * @param id 用户id
     * @param oldPasd 原密码
     * @param newPasd 新密码
     * @return 返回搜影响行数 为0表示修改失败 大于0表示修改成功
     */
    int modifyPassword(Integer id, String oldPasd, String newPasd);
}
