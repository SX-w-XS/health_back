package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.StatusConstant;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;

import com.sky.entity.Setmeal;
import com.sky.exception.DeletionNotAllowedException;
import com.sky.mapper.DishFlavorsMapper;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.service.impl
 * @Author: X_X
 * @Description:
 * @Version: 1.0
 */
@Service
@Slf4j
public class DishServiceImpl  implements DishService {
    @Autowired
    DishMapper dishMapper;
    @Autowired
    DishFlavorsMapper dishFlavorsMapper;
    @Autowired
    SetmealDishMapper setmealDishMapper;
    @Autowired
    SetmealMapper setmealMapper;



    @Transactional
    public void saveWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);

        //向菜品表插入
        dishMapper.insert(dish);
        //获取insert 主键值
        Long id = dish.getId();

        //向口味插入
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if(flavors!=null&&flavors.size()>0){
            flavors.forEach(dishFlavor -> {
                dishFlavor.setDishId(id);
            });
            dishFlavorsMapper.insertBatch(flavors);
        }

    }
    /**
     * @description:分页查询菜品
     * @author: X_X
     * @param: [dishDTO]
     * @return: com.sky.result.PageResult
     **/
    @Override
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(),dishPageQueryDTO.getPageSize());
        Page<DishVO> page=dishMapper.pageQuery(dishPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
   /**
    * @description:菜品批量删除
    * @author: X_X
    * @param: [ids]
    * @return: void
    **/
   @Transactional
    public void deleteBatch(List<Long> ids) {
       //判断是否在起售
        for (Long id : ids) {
          Dish dish=  dishMapper.getById(id);
          if(dish.getStatus()== StatusConstant.ENABLE){
              throw new DeletionNotAllowedException(MessageConstant.DISH_ON_SALE);
          }
        }

        //判断是否关联套餐
        List<Long> setmealIds=setmealDishMapper.getSetmealIdBYDishID(ids);
      if (setmealIds!=null&&setmealIds.size()>0 ){
          throw new DeletionNotAllowedException(MessageConstant.DISH_BE_RELATED_BY_SETMEAL);
      }

        //删除菜品
        /*for (Long id : ids) {
            dishMapper.deleteById(id);
            //删除口味
            dishFlavorsMapper.deleteByDishId(id);
        }*/
         dishMapper.deleteByDishIds(ids);

         dishFlavorsMapper.deleteByDishIds(ids);

    }
    /**
     * @description:根据ID查询口味和菜品
     * @author: X_X
     * @param: [id]
     * @return: com.sky.vo.DishVO
     **/
    @Override
    public DishVO getByIdWithFlavor(Long id) {
        //查询菜品
        Dish dish = dishMapper.getById(id);
        //查询口味
        List<DishFlavor> dishFlavors= dishFlavorsMapper.getByDishId(id);
        //分装
        DishVO dishVO=new DishVO();
        BeanUtils.copyProperties(dish,dishVO);
        dishVO.setFlavors(dishFlavors);
        return dishVO;
    }
  /**
   * @description:修改菜品
   * @author: X_X
   * @param: [dishDTO]
   * @return: void
   **/
    @Transactional
    @Override
    public void updateWithFlavor(DishDTO dishDTO) {
        Dish dish=new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        //修改菜品
        dishMapper.update(dish);
        //删除原有口味
        dishFlavorsMapper.deleteByDishId(dishDTO.getId());
        //重新插入
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if(flavors!=null&&flavors.size()>0){
            flavors.forEach(dishFlavor -> {
                dishFlavor.setDishId(dishDTO.getId());
            });
            dishFlavorsMapper.insertBatch(flavors);
        }

    }

    /**
     * 菜品起售停售
     *
     * @param status
     * @param id
     */
    @Transactional
    public void startOrStop(Integer status, Long id) {
        Dish dish = Dish.builder()
                .id(id)
                .status(status)
                .build();
        dishMapper.update(dish);

        if (status == StatusConstant.DISABLE) {
            // 如果是停售操作，还需要将包含当前菜品的套餐也停售
            List<Long> dishIds = new ArrayList<>();
            dishIds.add(id);
            // select setmeal_id from setmeal_dish where dish_id in (?,?,?)
            List<Long> setmealIds = setmealDishMapper.getSetmealIdBYDishID(dishIds);
            if (setmealIds != null && setmealIds.size() > 0) {
                for (Long setmealId : setmealIds) {
                    Setmeal setmeal = Setmeal.builder()
                            .id(setmealId)
                            .status(StatusConstant.DISABLE)
                            .build();
                    setmealMapper.update(setmeal);
                }
            }
        }
    }

    /**
     * 条件查询菜品和口味
     * @param dish
     * @return
     */
    public List<DishVO> listWithFlavor(Dish dish) {
        List<Dish> dishList = dishMapper.list(dish);

        List<DishVO> dishVOList = new ArrayList<>();

        for (Dish d : dishList) {
            DishVO dishVO = new DishVO();
            BeanUtils.copyProperties(d,dishVO);

            //根据菜品id查询对应的口味
            List<DishFlavor> flavors = dishFlavorsMapper.getByDishId(d.getId());

            dishVO.setFlavors(flavors);
            dishVOList.add(dishVO);
        }

        return dishVOList;
    }

    @Override
    public List<Dish> list(Long categoryId) {
        Dish dish = Dish.builder()
                .categoryId(categoryId)
                .status(StatusConstant.ENABLE)
                .build();
        return dishMapper.list(dish);
    }
}
