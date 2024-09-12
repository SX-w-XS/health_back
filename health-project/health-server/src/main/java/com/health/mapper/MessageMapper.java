package com.health.mapper;

import com.health.entities.Message;
import com.health.entities.MessageExample;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface MessageMapper extends Mapper<Message> {

}