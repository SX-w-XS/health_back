package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.mapper
 * @Author: X_X
 * @Description: 用户表
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
   /**
    * @description: 根据openid查询用户
    * @author: X_X
    * @param: [openid]
    * @return: com.sky.entity.User
    **/
    @Select("select  * from user where openid = #{openid}")
    User getByOpenid(String openid);
   /**
    * @description:插入数据
    * @author: X_X
    * @param: [user]
    * @return: void
    **/
    void insert(User user);

    @Select("select  * from user where id = #{userId}")
    User getById(Long userId);
}

