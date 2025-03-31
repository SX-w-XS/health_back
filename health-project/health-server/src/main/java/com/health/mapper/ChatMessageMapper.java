package com.health.mapper;

import com.health.entities.ChatMessage;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ChatMessageMapper extends Mapper<ChatMessage> {

    @Select("SELECT * FROM chat_message ORDER BY id DESC LIMIT #{limit}")
    List<ChatMessage> selectRecentMessages(int limit);
}