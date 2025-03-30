package com.health.mapper;

import com.health.entities.Message;
import com.health.entities.MessageExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface MessageMapper extends Mapper<Message> {

    @Select("select * from message order by MESSAGE_ID desc limit 5")
    List<Message> selectMessageFive();

    @Select("select count(*) from message")
    Integer countMessage();
}