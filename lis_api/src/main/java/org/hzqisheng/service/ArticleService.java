package org.hzqisheng.service;

import org.lis_entity.*;

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

    /**
     * 通过文章id查找文章的标签
     * @param articleId
     * @return
     */
    public List<Category> findArticleCategoryByArticleId(Long articleId);

    /**
     * 通过文章id统计评论数量
     * @param articleId
     * @return
     */
    public long countCommentByArticleId(Long articleId);

    /**
     * 通过文章id获得评论列表
     * @param articleId
     * @return
     */
    public List<CommentResult> getCommentListByArticleId(Long articleId);

    /**
     *
     * @param commentId
     * @return
     */
    public List<ReplayResult> getReplyListByCommentId(Long commentId);
}