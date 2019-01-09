package org.hzqisheng.service.Impl;

import org.hzqisheng.service.ArticleService;
import org.lis_dao.*;
import org.lis_entity.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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
    @Resource
    CollectionDao collectionDao;
    @Resource
    ReplayDao replayDao;
    @Resource
    UserDao userDao;
    @Resource
    NewsDao newsDao;
    @Override
    public List<Category> findCategoryList() {
        CategoryExample categoryExample = new CategoryExample();
        return categoryDao.selectByExample(categoryExample);
    }

    @Override
    public List<ArticleResult> getArticleList() {
        return articleDao.selectAllArticleResultList();
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
    public ArticleResult findArticleResultByArticle(Article article) {
        return articleDao.selectByArticleResultByArticleId(article.getArticleId());
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

    @Override
    public boolean addReadCountByArticleId(Long articleId) {
        Article article=articleDao.selectByPrimaryKey(articleId);
        Long articleReadCount=article.getReadCount();
        articleReadCount=articleReadCount+1;
        article.setReadCount(articleReadCount);
        return articleDao.updateByPrimaryKeySelective(article) > 0;
    }

    @Override
    public boolean findCollectionByArticleIdAndUserId(Long articleId, Long userId) {
        CollectionExample collectionExample=new CollectionExample();
        CollectionExample.Criteria criteria=collectionExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        criteria.andUserIdEqualTo(userId);
        return collectionDao.countByExample(collectionExample) > 0;
    }

    @Override
    public String  addOrDeleteCollectionByArticleIdAndUserIdAndCollectionResult(Long articleId, Long userId, boolean collectionResult) {
        if(collectionResult) {
           CollectionExample collectionExample=new CollectionExample();
           CollectionExample.Criteria criteria=collectionExample.createCriteria();
           criteria.andUserIdEqualTo(userId);
           criteria.andArticleIdEqualTo(articleId);
           collectionDao.deleteByExample(collectionExample);
            return "noCollect";
        }else{
            Collection collection = new Collection();
            collection.setArticleId(articleId);
            collection.setUserId(userId);
            collection.setCreateTime(new Date());
            collectionDao.insertSelective(collection);
            return "collect";
        }

    }

    @Override
    public boolean addComment(Comment comment) {
        comment.setCreateTime(new Date());
        return commentDao.insertSelective(comment) > 0;
    }

    @Override
    public boolean addReplay(Replay replay) {
        replay.setCreateTime(new Date());
        return replayDao.insertSelective(replay) > 0;
    }

    @Override
    public boolean addNew(News news, String repliedName) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameEqualTo(repliedName);
        List<User> userList=userDao.selectByExample(userExample);
        User user=userList.get(0);
        news.setUserId(user.getUserId());
        news.setStatus(0);
        news.setCreateTime(new Date());
        return newsDao.insertSelective(news) > 0;
    }
}

