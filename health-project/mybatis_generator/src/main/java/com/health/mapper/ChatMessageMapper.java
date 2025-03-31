package com.health.mapper;

import com.health.entities.ChatMessage;
import com.health.entities.ChatMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ChatMessageMapper extends Mapper<ChatMessage> {

}