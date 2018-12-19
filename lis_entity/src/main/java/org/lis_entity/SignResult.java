package org.lis_entity;

import java.util.Date;

/**
 * @Author thlnkpad
 * @Date 2018/12/18 11:28
 **/
public class SignResult {
    /**
     * 用户名
     */
    private String username;
    /**
     * 签到时间
     */
    private Date signTime;

    private Long signId;
    public SignResult(String username, Date signTime) {
        this.username = username;
        this.signTime = signTime;
    }

    public SignResult() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Long getSignId() {
        return signId;
    }

    public void setSignId(Long signId) {
        this.signId = signId;
    }
}
