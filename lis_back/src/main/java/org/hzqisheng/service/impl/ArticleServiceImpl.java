package org.hzqisheng.service.impl;

import org.hzqisheng.service.ArticleService;
import org.lis_dao.ArticleCategoryDao;
import org.lis_dao.ArticleDao;
import org.lis_dao.CategoryDao;
import org.lis_entity.*;
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
    @Resource
    CategoryDao categoryDao;
    @Resource
    ArticleCategoryDao articleCategoryDao;
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

    @Override
    public boolean addArticle(String  author,Article article,  Long[] categoryIds) {
        Date date=new Date();
        article.setAuthor(author);
        article.setReadCount(0L);
        article.setCreateTime(date);
        article.setUpdateTime(date);
        articleDao.updateByPrimaryKeySelective(article);
        Long articleId=article.getArticleId();
        if(null!=categoryIds && categoryIds.length!=0) {
            for (Long categoryId : categoryIds) {
                ArticleCategory articleCategory = new ArticleCategory();
                articleCategory.setArticleId(articleId);
                articleCategory.setCategoryId(categoryId);
                articleCategoryDao.insertSelective(articleCategory);
            }
        }
       return true;
    }

    @Override
    public boolean updateArticle(Article article, Long[] categoryIds) {
        Long articleId=article.getArticleId();
        article.setUpdateTime(new Date());
        articleDao.updateByPrimaryKeySelective(article);
        if(null!=categoryIds && categoryIds.length!=0){
            ArticleCategoryExample articleCategoryExample=new ArticleCategoryExample();
            ArticleCategoryExample.Criteria criteria=articleCategoryExample.createCriteria();
            criteria.andArticleIdEqualTo(articleId);
            articleCategoryDao.deleteByExample(articleCategoryExample);
            for (Long categoryId : categoryIds) {
                ArticleCategory articleCategory = new ArticleCategory();
                articleCategory.setArticleId(articleId);
                articleCategory.setCategoryId(categoryId);
                articleCategoryDao.insertSelective(articleCategory);
            }
        }
            return true;
    }
}


