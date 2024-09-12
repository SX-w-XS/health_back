package com.health.mapper;

import com.health.entities.User;
import com.health.entities.UserExample;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface UserMapper extends Mapper<User> {

}