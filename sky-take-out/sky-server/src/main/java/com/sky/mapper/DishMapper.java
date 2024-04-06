package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
    /**
     * @description:插入菜品
     * @author: X_X
     * @param: [dish]
     * @return: void
     **/
    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);
 /**
  * @description:菜品分页
  * @author: X_X
  * @param: [dishPageQueryDTO]
  * @return: com.github.pagehelper.Page<com.sky.vo.DishVO>
  **/
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);
   /**
    * @description:根据主键查询
    * @author: X_X
    * @param: [id]
    * @return: com.sky.entity.Dish
    **/
    @Select("select  * from  dish where  id=#{id}")
    Dish getById(Long id);
    /**
     * @description:根据主键查询
     * @author: X_X
     * @param: [id]
     * @return: void
     **/
    @Delete("delete  from dish where id = #{id}")
    void deleteById(Long id);

    void deleteByDishIds(List<Long> dishIds);

    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    List<Dish> list(Dish dish);

    /**
     * 根据套餐id查询菜品
     * @param setmealId
     * @return
     */
    @Select("select a.* from dish a left join setmeal_dish b on a.id = b.dish_id where b.setmeal_id = #{setmealId}")
    List<Dish> getBySetmealId(Long setmealId);

}
