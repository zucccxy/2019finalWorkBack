package org.hzqisheng.service;

import org.lis_entity.Category;

import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/27 16:37
 **/
public interface ArticleService {
    /**
     * 获取Tag列表
     * @return
     */
    public List<Category> findCategoryList();
}
