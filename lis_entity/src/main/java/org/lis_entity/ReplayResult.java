package org.lis_entity;

import java.util.Date;

/**
 * @Author thlnkpad
 * @Date 2018/12/25 15:15
 **/
public class ReplayResult {
    /**
     * 回复id
     */
    private Long replyId;
    /**
     * 回复内容
     */
    private String replyContent;
    /**
     * 用户头像
     */
    private String  avatarurl;
    /**
     * 用户名
     */
    private String username;
    /**
     * 回复创建时间
     */
    private Date createTime;

    /**
     * 被回复人姓名
     */
    private String repliedName;



    public ReplayResult() {
    }

    public ReplayResult(Long replyId, String replyContent, String username, Date createTime) {
        this.replyId = replyId;
        this.replyContent = replyContent;
        this.username = username;
        this.createTime = createTime;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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

    public String getRepliedName() {
        return repliedName;
    }

    public void setRepliedName(String repliedName) {
        this.repliedName = repliedName;
    }



}
