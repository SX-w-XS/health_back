package com.health.mapper;

import com.health.entities.User;
import com.health.entities.UserExample;
import com.health.vo.UserPredictUPVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
public interface UserMapper extends Mapper<User> {
    @Select("select count(*) from health.h_user where role !=1")
    Integer selectTotal();

    @Select("select count(*) from health.h_user where user_sex =1")
    Integer selectMan();

    @Select("select count(*) from health.h_user where user_sex =2")
    Integer selectWoman();


    List<UserPredictUPVO> findDailyGrowth(@Param("start") LocalDate start,
                                          @Param("end") LocalDate end);
}