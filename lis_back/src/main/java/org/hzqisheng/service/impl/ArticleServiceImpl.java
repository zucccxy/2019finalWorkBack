package org.hzqisheng.service.impl;

import org.hzqisheng.service.ArticleService;
import org.lis_dao.*;
import org.lis_entity.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
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
    @Resource
    CommentDao commentDao;
    @Resource
    ReplayDao replayDao;
    public List<Article> findArticleList(String title, String expect, String author, Date startTime, Date endTime){
//        ArticleExample articleExample=new ArticleExample();
//        ArticleExample.Criteria criteria=articleExample.createCriteria();
//        if(null!=title&&!"".equals(title)){
//            criteria.andTitleLike("%"+title+"%");
//         }
//        if(null!=expect&&!"".equals(expect)){
//            criteria.andExpectLike("%"+expect+"%");
//        }
//        if(null!=author&&!"".equals(author)){
//            criteria.andAuthorLike("%"+author+"%");
//        }
//       if(null!=startTime){
//           criteria.andUpdateTimeGreaterThanOrEqualTo(startTime);
//       }
//       if(null!=endTime){
//           criteria.andUpdateTimeLessThanOrEqualTo(endTime);
//       }
//       articleExample.setOrderByClause("author");
//        return articleDao.selectByExample(articleExample);
        return null;
    }


    @Override
    public boolean addArticle(String  author,Article article,  Long[] categoryIds) {
//        Date date=new Date();
//        article.setAuthor(author);
//        article.setReadCount(0L);
//        article.setCreateTime(date);
//        article.setUpdateTime(date);
//        articleDao.updateByPrimaryKeySelective(article);
//        Long articleId=article.getArticleId();
//        if(null!=categoryIds && categoryIds.length!=0) {
//            for (Long categoryId : categoryIds) {
//                ArticleCategory articleCategory = new ArticleCategory();
//                articleCategory.setArticleId(articleId);
//                articleCategory.setCategoryId(categoryId);
//                articleCategoryDao.insertSelective(articleCategory);
//            }
//        }
       return true;
    }

    @Override
    public boolean updateArticle(Article article, Long[] categoryIds) {
//        Long articleId=article.getArticleId();
//        article.setUpdateTime(new Date());
//        articleDao.updateByPrimaryKeySelective(article);
//        if(null!=categoryIds && categoryIds.length!=0){
//            ArticleCategoryExample articleCategoryExample=new ArticleCategoryExample();
//            ArticleCategoryExample.Criteria criteria=articleCategoryExample.createCriteria();
//            criteria.andArticleIdEqualTo(articleId);
//            articleCategoryDao.deleteByExample(articleCategoryExample);
//            for (Long categoryId : categoryIds) {
//                ArticleCategory articleCategory = new ArticleCategory();
//                articleCategory.setArticleId(articleId);
//                articleCategory.setCategoryId(categoryId);
//                articleCategoryDao.insertSelective(articleCategory);
//            }
//        }
            return true;
    }

    @Override
    public boolean delArticle(Long articleId) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        List<Comment> commentList=commentDao.selectByExample(commentExample);
        for(Comment comment:commentList){
            delComment(comment.getCommentId());
        }
        commentDao.deleteByExample(commentExample);
        return articleDao.deleteByPrimaryKey(articleId) > 0;
    }

    @Override
    public List<CommentResult> findCommentList(String username, String title, String commentContent, Date startTime, Date endTime) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("username",username);
        map.put("title",title);
        map.put("commentContent",commentContent);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return articleDao.selectByCommentResultCondition(map);
    }

    @Override
    public boolean delComment(Long commentId) {
        ReplayExample replayExample=new ReplayExample();
        ReplayExample.Criteria criteria=replayExample.createCriteria();
        criteria.andCommentIdEqualTo(commentId);
        replayDao.deleteByExample(replayExample);
        return  commentDao.deleteByPrimaryKey(commentId) > 0 ;
    }

    @Override
    public List<ReplayResult> findReplayResult(Long commentId, String username, String replyContent, Date startTime, Date endTime) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("commentId",commentId);
        map.put("username",username);
        map.put("replyContent",replyContent);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        return articleDao.selectByReplayResultCondition(map);
    }

    @Override
    public boolean delRepaly(Long replyId) {
        return replayDao.deleteByPrimaryKey(replyId) > 0;
    }
}


