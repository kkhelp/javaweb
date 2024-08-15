package com.javaweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 用户实体类
 */
public class SysUser {
    private Integer id;
    private String userName;
    private String password;
    private String nickName;
}
