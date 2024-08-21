package com.atguigu.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 17932
 * @date 2024/8/20 20:08
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDelivery {
    private Integer id;
    private Integer company_id;
    private Integer user_id;
    private String phone;
    private String arrive_date;
    private String address;
    private Integer status;
}
