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
    public List<ArticleResult> getArticleList();

    /**
     * 通过标签查找文章
     * @param categoryId
     * @return
     */
    public List<Article> findArticleListByCategory(Long categoryId);

    /**
     * 通过标签查找文章详情
     */
    public ArticleResult  findArticleResultByArticle(Article article);

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
     * 通过评论Id获取回复列表
     * @param commentId
     * @return
     */
    public List<ReplayResult> getReplyListByCommentId(Long commentId);

    /**
     * 通过文章id增加回复数
     * @param articleId
     * @return
     */
    public boolean addReadCountByArticleId(Long articleId);


    /**
     * 通过文章ID和用户ID获取是否收藏文章
     * @param articleId
     * @param userId
     * @return
     */
    public boolean findCollectionByArticleIdAndUserId(Long articleId,Long userId);

    /**
     * 通过标志位判断收藏还是取消收藏(false表示未收藏,true表示收藏
     * @param articleId
     * @param userId
     * @param collectionResult
     * @return
     */
    public String  addOrDeleteCollectionByArticleIdAndUserIdAndCollectionResult(Long articleId,Long userId,boolean collectionResult);

    /**
     * 增加评论
     * @param comment
     * @return
     */
    public boolean addComment(Comment comment);

    /**
     * 增加回复
     * @param replay
     * @return
     */
    public boolean addReplay(Replay replay);
}