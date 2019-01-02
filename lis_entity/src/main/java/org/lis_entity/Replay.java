package org.lis_entity;

import java.io.Serializable;
import java.util.Date;

/**
 * replay
 * @author 
 */
public class Replay implements Serializable {
    /**
     * 回复id
     */
    private Long replyId;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复作者
     */
    private Long userId;

    /**
     * 评论id
     */
    private Long commentId;

    /**
     * 回复创建时间
     */
    private Date createTime;

    /**
     * 被回复人姓名
     */
    private String repliedName;

    private static final long serialVersionUID = 1L;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Replay other = (Replay) that;
        return (this.getReplyId() == null ? other.getReplyId() == null : this.getReplyId().equals(other.getReplyId()))
            && (this.getReplyContent() == null ? other.getReplyContent() == null : this.getReplyContent().equals(other.getReplyContent()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRepliedName() == null ? other.getRepliedName() == null : this.getRepliedName().equals(other.getRepliedName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReplyId() == null) ? 0 : getReplyId().hashCode());
        result = prime * result + ((getReplyContent() == null) ? 0 : getReplyContent().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRepliedName() == null) ? 0 : getRepliedName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", replyId=").append(replyId);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", userId=").append(userId);
        sb.append(", commentId=").append(commentId);
        sb.append(", createTime=").append(createTime);
        sb.append(", repliedName=").append(repliedName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}