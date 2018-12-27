package org.hzqisheng.service;

import org.lis_entity.Article;
import org.lis_entity.CommentResult;
import org.lis_entity.ReplayResult;

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

    /**
     * 删除博文
     * @param articleId
     * @return
     */
    public boolean delArticle(Long  articleId);

    /**
     * 评论列表
     * @param username
     * @param title
     * @param commentContent
     * @param startTime
     * @param endTime
     * @return
     */
    public List<CommentResult> findCommentList(String username, String title, String commentContent, Date startTime, Date endTime);

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    public boolean delComment(Long  commentId);
    /**
     * 回复列表
     * @param commentId
     * @param username
     * @param replyContent
     * @param startTime
     * @param endTime
     * @return
     */
    public List<ReplayResult> findReplayResult(Long commentId,String username,String replyContent,Date startTime,Date endTime);

    /**
     * 删除回复
     * @param replyId
     * @return
     */
    public boolean delRepaly(Long  replyId);
}
