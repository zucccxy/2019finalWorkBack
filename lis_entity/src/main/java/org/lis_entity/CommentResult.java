package org.lis_entity;

import java.util.Date;

/**
 * @Author thlnkpad
 * @Date 2018/12/25 13:56
 **/
public class CommentResult {
    /**
     * 评论id
     */
    private Long commentId;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 博文标题
     */
    private String title;
    /**
     * 评论创建时间
     */
    private Date createTime;
    /**
     * 用户名
     */
    private String username;

    public CommentResult() {
    }

    public CommentResult(Long commentId, String commentContent, String title, Date createTime, String username) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.title = title;
        this.createTime = createTime;
        this.username = username;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
