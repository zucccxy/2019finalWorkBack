package org.lis_entity;

import java.util.Date;

/**
 * @Author thlnkpad
 * @Date 2019/1/11 13:23
 **/
public class NewsResult {
    /**
     * 消息id
     */
    private Long newsId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;
    /**
     * 博文id
     */
    private Long articleId;

    /**
     * 消息状态，0表示消息未被读取，1表示消息被读取
     */
    private Integer status;

    /**
     * 消息内容
     */
    private String newsContent;

    /**
     * 消息创建时间
     */
    private Date createTime;

    public NewsResult() {
    }

    public NewsResult(Long newsId, Long userId, String username, Long articleId, Integer status, String newsContent, Date createTime) {
        this.newsId = newsId;
        this.userId = userId;
        this.username = username;
        this.articleId = articleId;
        this.status = status;
        this.newsContent = newsContent;
        this.createTime = createTime;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
