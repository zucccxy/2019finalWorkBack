package org.hzqisheng.service;

import org.lis_entity.Article;
import org.lis_entity.Category;

import java.util.Date;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/19 9:39
 **/
public interface ArticleService {
    /**
     * 博文列表
     * @param title
     * @param expect
     * @param author
     * @param createTime
     * @param updateTime
     * @return
     */
    public List<Article>  findArticleList(String title, String expect, String author, Date createTime,Date updateTime);

    /**
     * 新增博文
     * @param author
     * @param article
     * @param categoryIds
     * @return
     */
    public boolean addArticle(String author,Article article,  Long[] categoryIds);

    /**
     * 更新博文
     * @param article
     * @param categoryIds
     * @return
     */
    public boolean updateArticle(Article article,Long []categoryIds);

        }
