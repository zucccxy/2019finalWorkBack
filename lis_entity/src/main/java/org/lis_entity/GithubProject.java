package org.lis_entity;

import java.io.Serializable;

/**
 * github_project
 * @author 
 */
public class GithubProject implements Serializable {
    /**
     * github项目id
     */
    private Long projectId;

    /**
     * github项目地址
     */
    private String projectAddress;

    /**
     * github项目开发语言
     */
    private String projectLanguage;

    /**
     * github项目fork数量
     */
    private Long projectFork;

    /**
     * github项目star数
     */
    private Long projectStar;

    /**
     * github项目issue数
     */
    private Long projectIssue;

    /**
     * github项目readme.md
     */
    private String projectReadme;

    /**
     * github作者头像地址
     */
    private String projectAvatarurl;

    /**
     * github项目作者名字
     */
    private String projectAuthor;

    /**
     * github项目名字
     */
    private String projectName;

    /**
     * github项目简述
     */
    private String projectDes;

    private static final long serialVersionUID = 1L;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public String getProjectLanguage() {
        return projectLanguage;
    }

    public void setProjectLanguage(String projectLanguage) {
        this.projectLanguage = projectLanguage;
    }

    public Long getProjectFork() {
        return projectFork;
    }

    public void setProjectFork(Long projectFork) {
        this.projectFork = projectFork;
    }

    public Long getProjectStar() {
        return projectStar;
    }

    public void setProjectStar(Long projectStar) {
        this.projectStar = projectStar;
    }

    public Long getProjectIssue() {
        return projectIssue;
    }

    public void setProjectIssue(Long projectIssue) {
        this.projectIssue = projectIssue;
    }

    public String getProjectReadme() {
        return projectReadme;
    }

    public void setProjectReadme(String projectReadme) {
        this.projectReadme = projectReadme;
    }

    public String getProjectAvatarurl() {
        return projectAvatarurl;
    }

    public void setProjectAvatarurl(String projectAvatarurl) {
        this.projectAvatarurl = projectAvatarurl;
    }

    public String getProjectAuthor() {
        return projectAuthor;
    }

    public void setProjectAuthor(String projectAuthor) {
        this.projectAuthor = projectAuthor;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDes() {
        return projectDes;
    }

    public void setProjectDes(String projectDes) {
        this.projectDes = projectDes;
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
        GithubProject other = (GithubProject) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectAddress() == null ? other.getProjectAddress() == null : this.getProjectAddress().equals(other.getProjectAddress()))
            && (this.getProjectLanguage() == null ? other.getProjectLanguage() == null : this.getProjectLanguage().equals(other.getProjectLanguage()))
            && (this.getProjectFork() == null ? other.getProjectFork() == null : this.getProjectFork().equals(other.getProjectFork()))
            && (this.getProjectStar() == null ? other.getProjectStar() == null : this.getProjectStar().equals(other.getProjectStar()))
            && (this.getProjectIssue() == null ? other.getProjectIssue() == null : this.getProjectIssue().equals(other.getProjectIssue()))
            && (this.getProjectReadme() == null ? other.getProjectReadme() == null : this.getProjectReadme().equals(other.getProjectReadme()))
            && (this.getProjectAvatarurl() == null ? other.getProjectAvatarurl() == null : this.getProjectAvatarurl().equals(other.getProjectAvatarurl()))
            && (this.getProjectAuthor() == null ? other.getProjectAuthor() == null : this.getProjectAuthor().equals(other.getProjectAuthor()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectDes() == null ? other.getProjectDes() == null : this.getProjectDes().equals(other.getProjectDes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectAddress() == null) ? 0 : getProjectAddress().hashCode());
        result = prime * result + ((getProjectLanguage() == null) ? 0 : getProjectLanguage().hashCode());
        result = prime * result + ((getProjectFork() == null) ? 0 : getProjectFork().hashCode());
        result = prime * result + ((getProjectStar() == null) ? 0 : getProjectStar().hashCode());
        result = prime * result + ((getProjectIssue() == null) ? 0 : getProjectIssue().hashCode());
        result = prime * result + ((getProjectReadme() == null) ? 0 : getProjectReadme().hashCode());
        result = prime * result + ((getProjectAvatarurl() == null) ? 0 : getProjectAvatarurl().hashCode());
        result = prime * result + ((getProjectAuthor() == null) ? 0 : getProjectAuthor().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectDes() == null) ? 0 : getProjectDes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", projectAddress=").append(projectAddress);
        sb.append(", projectLanguage=").append(projectLanguage);
        sb.append(", projectFork=").append(projectFork);
        sb.append(", projectStar=").append(projectStar);
        sb.append(", projectIssue=").append(projectIssue);
        sb.append(", projectReadme=").append(projectReadme);
        sb.append(", projectAvatarurl=").append(projectAvatarurl);
        sb.append(", projectAuthor=").append(projectAuthor);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectDes=").append(projectDes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}