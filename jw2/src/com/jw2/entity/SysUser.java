package com.jw2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 17932
 * @date 2024/8/20 15:04
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
}
