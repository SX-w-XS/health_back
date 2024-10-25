package com.health.mapper;

import com.health.entities.Message;
import com.health.entities.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface MessageMapper extends Mapper<Message> {
    long countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    List<Message> selectByExampleWithBLOBs(MessageExample example);

    List<Message> selectByExample(MessageExample example);

    int updateByExampleSelective(@Param("row") Message row, @Param("example") MessageExample example);

    int updateByExampleWithBLOBs(@Param("row") Message row, @Param("example") MessageExample example);

    int updateByExample(@Param("row") Message row, @Param("example") MessageExample example);
}