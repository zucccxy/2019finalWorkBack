package org.hzqisheng.service.Impl;

import org.hzqisheng.service.GithubService;
import org.lis_dao.GithubProjectDao;
import org.lis_entity.GithubProject;
import org.lis_entity.GithubProjectExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2019/1/15 16:44
 **/
@Service("githubServiceImpl")
public class GithubServiceImpl implements GithubService {
    @Resource
    GithubProjectDao githubProjectDao;
    @Override
    public boolean isEmptyGithubProject() {
        GithubProjectExample githubProjectExample=new GithubProjectExample();
//        GithubProjectExample.Criteria criteria=githubProjectExample.createCriteria();
        Long count=githubProjectDao.countByExample(githubProjectExample);
        return count == 0;
//        if(count == 0){
//            return true;
//        }
//        else{
//            return false;
//        }
    }

    @Override
    public boolean addGithubProject(List<GithubProject> githubProjectList) {
        for(GithubProject githubProject:githubProjectList) {
            githubProjectDao.insertSelective(githubProject);
        }
        return true;
    }

    @Override
    public boolean deleteGithubProject() {
        GithubProjectExample githubProjectExample=new GithubProjectExample();
//        GithubProjectExample.Criteria criteria=githubProjectExample.createCriteria();

        return  githubProjectDao.deleteByExample(githubProjectExample) > 0;
    }
}
