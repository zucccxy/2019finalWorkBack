package org.hzqisheng.service;

import org.lis_entity.Article;
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

    /**
     * 获取文章列表
     * @return
     */
    public List<Article> getArticleList();

    /**
     * 通过标签查找文章
     * @param categoryId
     * @return
     */
    public List<Article> findArticleListByCategory(Long categoryId);

    /**
     * 通过文章id查找文章
     * @param articleId
     * @return
     */
    public Article findArticleListByArticleId(Long articleId);
}
