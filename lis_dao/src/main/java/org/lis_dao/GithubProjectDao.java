package org.lis_dao;

import org.lis_entity.GithubProject;
import org.lis_entity.GithubProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GithubProjectDao {
    long countByExample(GithubProjectExample example);

    int deleteByExample(GithubProjectExample example);

    int deleteByPrimaryKey(Long projectId);

    int insert(GithubProject record);

    int insertSelective(GithubProject record);

    List<GithubProject> selectByExample(GithubProjectExample example);

    GithubProject selectByPrimaryKey(Long projectId);

    int updateByExampleSelective(@Param("record") GithubProject record, @Param("example") GithubProjectExample example);

    int updateByExample(@Param("record") GithubProject record, @Param("example") GithubProjectExample example);

    int updateByPrimaryKeySelective(GithubProject record);

    int updateByPrimaryKey(GithubProject record);
}