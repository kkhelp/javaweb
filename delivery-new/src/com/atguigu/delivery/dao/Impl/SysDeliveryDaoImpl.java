package com.atguigu.delivery.dao.Impl;

import com.atguigu.delivery.dao.BaseDao;
import com.atguigu.delivery.dao.SysDeliveryDao;
import com.atguigu.delivery.entity.SysDelivery;
import com.atguigu.delivery.utils.JDBCUtils;

import java.util.List;

/**
 * @author 17932
 * @date 2024/8/20 20:13
 * @description TODO
 */
public class SysDeliveryDaoImpl extends BaseDao implements SysDeliveryDao {
    @Override
    // 新增
    public int addDelivery(SysDelivery sysDelivery) {
        String sql = "insert into sys_delivery(company_id,user_id,phone,arrive_date,address,status) values(?,?,?,?,?,?)";
        return baseUpdate(JDBCUtils.getConnection(), sql, sysDelivery.getCompany_id(), sysDelivery.getUser_id(), sysDelivery.getPhone(), sysDelivery.getArrive_date(), sysDelivery.getAddress(), sysDelivery.getStatus());
    }
    @Override
    // 删除
    public int deleteDelivery(Integer id) {
        String sql = "delete from sys_delivery where id = ?";
        return baseUpdate(JDBCUtils.getConnection(), sql, id);
    }
    @Override
    // 修改
    public int modifyDelivery(SysDelivery sysDelivery) {
        String sql = "update sys_delivery set company_id = ?,user_id = ?,phone = ?,arrive_date = ?,address = ?,status = ? where id = ?";
        return baseUpdate(JDBCUtils.getConnection(), sql, sysDelivery.getCompany_id(), sysDelivery.getUser_id(), sysDelivery.getPhone(), sysDelivery.getArrive_date(), sysDelivery.getAddress(), sysDelivery.getStatus(), sysDelivery.getId());
    }
    @Override
    // 根据user_id查询快递信息
    public List<SysDelivery> getDeliveryByUserId(Integer user_id) {
        String sql = "select id,company_id,user_id,phone,arrive_date,address,status from sys_delivery where user_id = ?";
        return baseQuery(JDBCUtils.getConnection(), sql, SysDelivery.class, user_id);
    }
    @Override
    // 根据id查询快递信息
    public SysDelivery getDeliveryById(Integer id) {
        String sql = "select id,company_id,user_id,phone,arrive_date,address,status from sys_delivery where id = ?";
        List<SysDelivery> sysDeliveries = baseQuery(JDBCUtils.getConnection(), sql, SysDelivery.class, id);
        return sysDeliveries.size() == 0 ? null : sysDeliveries.get(0);
    }
}
