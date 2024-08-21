package com.atguigu.delivery.dao;

import com.atguigu.delivery.entity.SysDelivery;

import java.util.List;

/**
 * @author 17932
 * @date 2024/8/20 20:13
 * @description TODO
 */
public interface SysDeliveryDao {
    // 新增
    int addDelivery(SysDelivery sysDelivery);

    // 删除
    int deleteDelivery(Integer id);

    // 修改
    int modifyDelivery(SysDelivery sysDelivery);

    // 根据user_id查询快递信息
    List<SysDelivery> getDeliveryByUserId(Integer user_id);

    // 根据id查询快递信息
    SysDelivery getDeliveryById(Integer id);
}
