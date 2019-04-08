package org.hzqisheng.service;

import org.lis_entity.Category;

import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/24 10:36
 **/
public interface CategoryService {
    /**
     * 标签列表
     * @return
     */
    public List<Category> getCategoryList();

    /**
     * 通过文章Id查找标签
     * @param articleId
     * @return
     */
    public List<Category> findCatergoryList(Long articleId);

    /**
     * 通过博文标签名称查找标签
     * @param categoryName
     * @return
     */
    public List<Category> findCategoryListByCategoryName(String categoryName);

    /**
     * 添加博文标签
     * @param category
     * @return
     */
    public boolean addCategory(Category category);

    /**
     * 修改博文标签信息
     * @param category
     * @return
     */
    public boolean updateCategory(Category category);

    public boolean deleteCategory(Long categoryId);

}
