package org.lis_entity;

import java.util.Date;

/**
 * @Author thlnkpad
 * @Date 2019/1/2 19:33
 **/
public class ArticleResult {
    /**
     * 博文id
     */
    private Long articleId;

    /**
     * 博文标题
     */
    private String title;

    /**
     * 博文内容概述
     */
    private String expect;

    /**
     * 管理员id
     */
    private Long adminId;

    /**
     * 博文阅读量
     */
    private Long readCount;

    /**
     * 博文创建时间
     */
    private Date createTime;

    /**
     * 博文更新时间
     */
    private Date updateTime;

    /**
     * 博文内容
     */
    private String content;
    /**
     *  管理员姓名
     */
    private String adminName;

    /**
     * 管理员头像的url
     */
    private String adminPic;


    public ArticleResult() {
    }

    public ArticleResult(Long articleId, String title, String expect, Long adminId, Long readCount, Date createTime, Date updateTime, String content, String adminName, String adminPic) {
        this.articleId = articleId;
        this.title = title;
        this.expect = expect;
        this.adminId = adminId;
        this.readCount = readCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
        this.adminName = adminName;
        this.adminPic = adminPic;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPic() {
        return adminPic;
    }

    public void setAdminPic(String adminPic) {
        this.adminPic = adminPic;
    }
}
