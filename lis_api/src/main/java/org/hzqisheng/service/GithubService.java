package org.hzqisheng.service;

import org.lis_entity.GithubProject;

import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2019/1/15 16:44
 **/
public interface GithubService {
    /**
     * 判断数据库表github_project是否为空
     * @return
     */
    public boolean isEmptyGithubProject();

    /**
     * 增加github项目数据
     * @param githubProjectList
     * @return
     */
    public boolean addGithubProject(List<GithubProject> githubProjectList);
    /**
     * 删除github项目数据
     */
    public boolean  deleteGithubProject();
}
