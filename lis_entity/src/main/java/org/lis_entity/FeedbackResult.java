package org.lis_entity;

import java.util.Date;

/**
 * @Author thlnkpad
 * @Date 2018/12/18 16:35
 **/
public class FeedbackResult {
    /**
     * 用户反馈id
     */
    private Long feedbackId;
    /**
     * 用户名
     */
    private String username;

    /**
     * 反馈内容
     */
    private String feedbackContent;

    /**
     * 反馈人联系方式
     */
    private String contact;

    /**
     * 反馈创建时间
     */
    private Date creatTime;


    public FeedbackResult() {

    }

    public FeedbackResult(Long feedbackId, String username, String feedbackContent, String contact, Date creatTime) {
        this.feedbackId = feedbackId;
        this.username = username;
        this.feedbackContent = feedbackContent;
        this.contact = contact;
        this.creatTime = creatTime;
    }
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

}
