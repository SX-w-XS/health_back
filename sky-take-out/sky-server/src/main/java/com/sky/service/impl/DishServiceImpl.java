package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.service.impl
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Service
@Slf4j
public class DishServiceImpl  implements DishService {
    @Autowired
    DishMapper dishMapper;
    @Transactional
    public void saveWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);

        //向菜品表插入
        dishMapper.insert(dish);

        //向口味插入
    }
}
