package org.lis_dao;

import org.lis_entity.Replay;
import org.lis_entity.ReplayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplayDao {
    long countByExample(ReplayExample example);

    int deleteByExample(ReplayExample example);

    int deleteByPrimaryKey(Long replyId);

    int insert(Replay record);

    int insertSelective(Replay record);

    List<Replay> selectByExample(ReplayExample example);

    Replay selectByPrimaryKey(Long replyId);

    int updateByExampleSelective(@Param("record") Replay record, @Param("example") ReplayExample example);

    int updateByExample(@Param("record") Replay record, @Param("example") ReplayExample example);

    int updateByPrimaryKeySelective(Replay record);

    int updateByPrimaryKey(Replay record);
}