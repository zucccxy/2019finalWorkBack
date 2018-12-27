package org.lis_entity;

import java.util.Date;

/**
 * @Author thlnkpad
 * @Date 2018/12/25 9:30
 **/
public class CollectionResult {
    /**
     * 收藏表id
     */
    private Long collectionId;
    /**
     * 博文标题
     */
    private String title;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户收藏创建时间
     */
    private Date createTime;

    public CollectionResult() {
    }

    public CollectionResult(Long collectionId, String title, String username, Date createTime) {
        this.collectionId = collectionId;
        this.title = title;
        this.username = username;
        this.createTime = createTime;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
