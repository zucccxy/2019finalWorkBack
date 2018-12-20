package org.hzqisheng.service.impl;

import org.hzqisheng.service.ArticleService;
import org.lis_dao.ArticleDao;
import org.lis_entity.Article;
import org.lis_entity.ArticleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/19 9:43
 **/
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleDao articleDao;
    public List<Article> findArticleList(String title, String expect, String author, Date startTime, Date endTime){
        ArticleExample articleExample=new ArticleExample();
        ArticleExample.Criteria criteria=articleExample.createCriteria();
        if(null!=title&&!"".equals(title)){
            criteria.andTitleLike("%"+title+"%");
        }
        if(null!=expect&&!"".equals(expect)){
            criteria.andExpectLike("%"+expect+"%");
        }
        if(null!=author&&!"".equals(author)){
            criteria.andAuthorLike("%"+author+"%");
        }
       if(null!=startTime){
           criteria.andUpdateTimeGreaterThanOrEqualTo(startTime);
       }
       if(null!=endTime){
           criteria.andUpdateTimeLessThanOrEqualTo(endTime);
       }
       articleExample.setOrderByClause("author");
        return articleDao.selectByExample(articleExample);
    }
}


