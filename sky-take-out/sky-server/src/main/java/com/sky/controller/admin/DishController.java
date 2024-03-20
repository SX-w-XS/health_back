package com.sky.controller.admin;

import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.controller.admin
 * @Author: X_X
 * @Description: 菜品管理
 * @Version: 1.0
 */
@RestController
@RequestMapping
@Slf4j
@Api(tags = "菜品接口")
public class DishController {
    @Autowired
    private DishService dishService;
     /**
      * @description:新增菜品
      * @author: X_X
      * @param: [dishDTO]
      * @return: com.sky.result.Result
      **/
     @PostMapping
     @ApiOperation("新增菜品")

    public Result save(@RequestBody DishDTO dishDTO){
         Dish dish = new Dish();

         log.info("新增菜品 {}",dishDTO);
         dishService.saveWithFlavor(dishDTO);
        return  Result.success();
    }

}
