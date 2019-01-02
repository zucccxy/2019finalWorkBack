package org.lis_dao;

import org.lis_entity.*;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleDao {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long articleId);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long articleId);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<ArticleResult> selectByArticleResultCondition(HashMap map);


    List<CommentResult> selectByCommentResultCondition(HashMap map);

    List<ReplayResult>  selectByReplayResultCondition(HashMap map);

    ArticleResult selectByArticleResultByArticleId(Long articleId);

    List<Article> selectArticleListByCategoryId(Long categoryId);

    List<ArticleResult> selectAllArticleResultList();

    List<CommentResult>  selectCommentListByArticleId(Long articleId);

    List<ReplayResult> selectReplayListByCommentId(Long commentId);
}