package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;


public interface DishService {

    /**
     * @description:x保存菜品
     * @author: X_X
     * @param: [dishDTO]
     * @return: void
     **/
    public void saveWithFlavor(DishDTO dishDTO);

    /**
     * @description:菜品分页查询
     * @author: X_X
     * @param: [dishDTO]
     * @return: com.sky.result.PageResult
     **/
    PageResult pageQuery(DishPageQueryDTO dishDTO);
   /**
    * @description:菜品批量删除
    * @author: X_X
    * @param: [ids]
    * @return: void
    **/
    void deleteBatch(List<Long> ids);
    /**
     * @description:根据ID查询口味和菜品
     * @author: X_X
     * @param: [id]
     * @return: com.sky.vo.DishVO
     **/
    DishVO getByIdWithFlavor(Long id);
   /**
    * @description: 修改菜品
    * @author: X_X
    * @param: [dishDTO]
    * @return: void
    **/
    void updateWithFlavor(DishDTO dishDTO);
   /**
    * @description:根据id修改状态
    * @author: X_X
    * @param: [id, status]
    * @return: void
    **/
    void startOrStop(Integer status, Long id);

    /**
     * 条件查询菜品和口味
     * @param dish
     * @return
     */
    List<DishVO> listWithFlavor(Dish dish);
}
