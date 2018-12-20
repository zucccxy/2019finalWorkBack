package org.hzqisheng.service;

import org.lis_entity.Article;

import java.util.Date;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/19 9:39
 **/
public interface ArticleService {
    /**
     * 文章列表
     * @param title
     * @param expect
     * @param author
     * @param createTime
     * @param updateTime
     * @return
     */
    public List<Article>  findArticleList(String title, String expect, String author, Date createTime,Date updateTime);

}
