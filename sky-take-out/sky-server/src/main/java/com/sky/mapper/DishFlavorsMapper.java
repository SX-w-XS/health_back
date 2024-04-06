package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.mapper
 * @Author: X_X
 * @Description: 菜品口味表
 * @Version: 1.0
 */
@Mapper
public interface DishFlavorsMapper {
   /**
    * @description:批量插入sql
    * @author: X_X
    * @param: [flavors]
    * @return: void
    **/
     void insertBatch(List<DishFlavor> flavors) ;

    /**
     * @description:根据菜品id删除口味
     * @author: X_X
     * @param: [id]
     * @return: void
     **/
    @Delete("delete  from  dish_flavor where dish_id=#{dishId}")
    void deleteByDishId(Long dishId);

 void deleteByDishIds(List<Long> dishIds);

     @Select("select  * from dish_flavor where dish_id=#{dishID}")
    List<DishFlavor> getByDishId(Long dishId);
}
