package com.jw2.dao.impl;

import com.jw2.dao.BaseDao;
import com.jw2.dao.SysStoryDao;
import com.jw2.entity.SysStory;

/**
 * @author 17932
 * @date 2024/8/20 18:53
 * @description TODO
 */
public class SysStoryDaoImpl extends BaseDao implements SysStoryDao {
    @Override
    public SysStory getStoryById(Integer id) {
        String sql = "select id, title, content from sys_story where id = ?";
        return baseQuery(sql, SysStory.class, id);
    }
}
