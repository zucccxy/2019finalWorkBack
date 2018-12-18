package org.lis_entity;

import java.io.Serializable;

/**
 * admin
 * @author 
 */
public class Admin implements Serializable {
    /**
     * 管理员id
     */
    private Long adminId;

    /**
     * 管理员电话
     */
    private String adminPhone;

    /**
     *  管理员姓名
     */
    private String adminName;

    /**
     * 管理员性别，0表示男生，1表示女生
     */
    private Integer adminSex;

    /**
     * 管理员头像的url
     */
    private String adminPic;

    /**
     * 管理员权限水平，0表示root管理员，1表示普通管理员
     */
    private Integer adminLevel;

    /**
     * 管理员状态 0不使用，1使用，2删除
     */
    private Integer adminState;

    /**
     * 管理员密码
     */
    private String adminPwd;

    private static final long serialVersionUID = 1L;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(Integer adminSex) {
        this.adminSex = adminSex;
    }

    public String getAdminPic() {
        return adminPic;
    }

    public void setAdminPic(String adminPic) {
        this.adminPic = adminPic;
    }

    public Integer getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(Integer adminLevel) {
        this.adminLevel = adminLevel;
    }

    public Integer getAdminState() {
        return adminState;
    }

    public void setAdminState(Integer adminState) {
        this.adminState = adminState;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
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
        Admin other = (Admin) that;
        return (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getAdminPhone() == null ? other.getAdminPhone() == null : this.getAdminPhone().equals(other.getAdminPhone()))
            && (this.getAdminName() == null ? other.getAdminName() == null : this.getAdminName().equals(other.getAdminName()))
            && (this.getAdminSex() == null ? other.getAdminSex() == null : this.getAdminSex().equals(other.getAdminSex()))
            && (this.getAdminPic() == null ? other.getAdminPic() == null : this.getAdminPic().equals(other.getAdminPic()))
            && (this.getAdminLevel() == null ? other.getAdminLevel() == null : this.getAdminLevel().equals(other.getAdminLevel()))
            && (this.getAdminState() == null ? other.getAdminState() == null : this.getAdminState().equals(other.getAdminState()))
            && (this.getAdminPwd() == null ? other.getAdminPwd() == null : this.getAdminPwd().equals(other.getAdminPwd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getAdminPhone() == null) ? 0 : getAdminPhone().hashCode());
        result = prime * result + ((getAdminName() == null) ? 0 : getAdminName().hashCode());
        result = prime * result + ((getAdminSex() == null) ? 0 : getAdminSex().hashCode());
        result = prime * result + ((getAdminPic() == null) ? 0 : getAdminPic().hashCode());
        result = prime * result + ((getAdminLevel() == null) ? 0 : getAdminLevel().hashCode());
        result = prime * result + ((getAdminState() == null) ? 0 : getAdminState().hashCode());
        result = prime * result + ((getAdminPwd() == null) ? 0 : getAdminPwd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", adminPhone=").append(adminPhone);
        sb.append(", adminName=").append(adminName);
        sb.append(", adminSex=").append(adminSex);
        sb.append(", adminPic=").append(adminPic);
        sb.append(", adminLevel=").append(adminLevel);
        sb.append(", adminState=").append(adminState);
        sb.append(", adminPwd=").append(adminPwd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}