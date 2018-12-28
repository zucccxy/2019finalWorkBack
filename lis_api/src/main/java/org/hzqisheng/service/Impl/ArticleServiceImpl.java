package org.hzqisheng.service.Impl;

import org.hzqisheng.service.ArticleService;
import org.lis_dao.ArticleCategoryDao;
import org.lis_dao.ArticleDao;
import org.lis_dao.CategoryDao;
import org.lis_entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author thlnkpad
 * @Date 2018/12/27 16:42
 **/
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    CategoryDao categoryDao;
    @Resource
    ArticleDao articleDao;
    @Resource
    ArticleCategoryDao articleCategoryDao;
    @Override
    public List<Category> findCategoryList() {
        CategoryExample categoryExample=new CategoryExample();
        return categoryDao.selectByExample(categoryExample);
    }

    @Override
    public List<Article> getArticleList() {
        ArticleExample articleExample=new ArticleExample();
        return articleDao.selectByExample(articleExample);
    }

    @Override
    public List<Article> findArticleListByCategory(Long categoryId) {
//        ArticleCategoryExample articleCategoryExample=new ArticleCategoryExample();
//        ArticleCategoryExample.Criteria criteria=articleCategoryExample.createCriteria();
//        criteria.andCategoryIdEqualTo(category.getCategoryId());
//        List<ArticleCategory> articleCategoryList=articleCategoryDao.selectByExample(articleCategoryExample);
//        List<Article> articleList=new ArrayList<>();
//        for(ArticleCategory articleCategory:articleCategoryList){
//            Article article=articleDao.selectByPrimaryKey(articleCategory.getArticleId());
//            articleList.add(article);
//        }
        return articleDao.selectArticleListByCategoryId(categoryId);
    }

    @Override
    public Article findArticleListByArticleId(Long articleId) {
        return   articleDao.selectByPrimaryKey(articleId) ;
    }
}
