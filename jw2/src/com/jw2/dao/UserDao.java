package com.jw2.dao;

import com.jw2.entity.SysUser;

/**
 * @author 17932
 * @date 2024/8/20 15:01
 * @description TODO
 */
public interface UserDao {
    // 登录
    SysUser login(String username, String password);

    // 注册
    int register(SysUser sysUser);

    // 根据id查询用户
    SysUser getUserById(Integer id);

    // 修改密码
    int modifyPassword(Integer id, String oldPasd, String newPasd);
}
