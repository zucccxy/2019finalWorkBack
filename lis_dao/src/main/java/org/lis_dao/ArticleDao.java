package org.lis_dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.lis_entity.Article;
import org.lis_entity.ArticleExample;
import org.lis_entity.CommentResult;
import org.lis_entity.ReplayResult;

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

    List<CommentResult> selectByCommentResultCondition(HashMap map);

    List<ReplayResult>  selectByReplayResultCondition(HashMap map);

    List<Article> selectArticleListByCategoryId(Long categoryId);

    List<CommentResult>  selectCommentListByArticleId(Long articleId);

    List<ReplayResult> selectReplayListByCommentId(Long commentId);

}