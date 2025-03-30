package com.health.mapper;

import com.health.entities.User;
import com.health.entities.UserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.time.LocalDate;
import java.util.List;
public interface UserMapper extends Mapper<User> {
    @Select("select count(*) from health.h_user where role !=1")
    Integer selectTotal();

    @Select("select count(*) from health.h_user where user_sex =1")
    Integer selectMan();

    @Select("select count(*) from health.h_user where user_sex =2")
    Integer selectWoman();

    @Select("SELECT \n" +
            "            DATE(create_time) AS date,\n" +
            "            COUNT(user_id) AS count \n" +
            "        FROM health.h_user \n" +
            "        WHERE DATE(create_time) BETWEEN :start AND :end \n" +
            "        GROUP BY DATE(create_time) \n" +
            "        ORDER BY DATE(create_time)")
    List<Object[]> findDailyGrowth(@Param("start") LocalDate start,
                                   @Param("end") LocalDate end);
}