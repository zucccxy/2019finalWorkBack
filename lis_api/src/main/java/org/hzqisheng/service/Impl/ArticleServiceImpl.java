package org.hzqisheng.service.Impl;

import org.hzqisheng.service.ArticleService;
import org.lis_dao.ArticleCategoryDao;
import org.lis_dao.ArticleDao;
import org.lis_dao.CategoryDao;
import org.lis_dao.CommentDao;
import org.lis_entity.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Resource
    CommentDao commentDao;
    @Override
    public List<Category> findCategoryList() {
        CategoryExample categoryExample = new CategoryExample();
        return categoryDao.selectByExample(categoryExample);
    }

    @Override
    public List<Article> getArticleList() {
        ArticleExample articleExample = new ArticleExample();
        return articleDao.selectByExample(articleExample);
    }

    @Override
    public List<Article> findArticleListByCategory(Long categoryId) {
        return articleDao.selectArticleListByCategoryId(categoryId);
    }

    @Override
    public Article findArticleListByArticleId(Long articleId) {
        return articleDao.selectByPrimaryKey(articleId);
    }

    @Override
    public List<Category> findArticleCategoryByArticleId(Long articleId) {
        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        ArticleCategoryExample.Criteria criteria = articleCategoryExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        List<ArticleCategory> articleCategoryList = articleCategoryDao.selectByExample(articleCategoryExample);
        List<Category> categoryList = new ArrayList<>();
        for (ArticleCategory articleCategory : articleCategoryList) {
            Category category = categoryDao.selectByPrimaryKey(articleCategory.getCategoryId());
            categoryList.add(category);
        }
        return categoryList;
    }

    @Override
    public long  countCommentByArticleId(Long articleId) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        return commentDao.countByExample(commentExample);
    }

    @Override
    public List<CommentResult> getCommentListByArticleId(Long articleId) {
        return articleDao.selectCommentListByArticleId(articleId);
    }

    @Override
    public List<ReplayResult> getReplyListByCommentId(Long commentId) {
        return articleDao.selectReplayListByCommentId(commentId);
    }
}

