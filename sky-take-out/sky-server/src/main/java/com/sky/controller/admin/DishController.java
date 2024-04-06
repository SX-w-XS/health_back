package com.sky.controller.admin;

import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.controller.admin
 * @Author: X_X
 * @Description: 菜品管理
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/dish")
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


    /**
     * @description: 菜品信息分页查询
     * @author: X_X
     * @param: [dishDTO]
     * @return: com.sky.result.Result<com.sky.result.PageResult>
     **/
    @GetMapping("/page")
     @ApiOperation("分页查询菜品")
    public Result<PageResult> page(DishPageQueryDTO dishDTO){
       log.info("分页查询菜品 {}",dishDTO);
       PageResult pageResult = dishService.pageQuery(dishDTO);

          return Result.success(pageResult);
    }
    /**
     * @description: 删除菜品
     * @author: X_X
     * @param: [ids]
     * @return: com.sky.result.Result
     **/
    @DeleteMapping
    @ApiOperation("删除菜品")
    public  Result delete(@RequestParam List<Long> ids ){
        log.info("删除菜品{}",ids);
        dishService.deleteBatch(ids);

        return  Result.success();
    }
    @GetMapping("/{id}")
    @ApiOperation("根据ID查询菜品")
    public  Result<DishVO> getById(@PathVariable Long id){
        log.info("查询菜品",id);
        DishVO dishVO= dishService.getByIdWithFlavor(id);

        return  Result.success(dishVO);
    }
    @PutMapping
    @ApiOperation("修改菜品")
    public  Result update(@RequestBody DishDTO dishDTO){
         log.info("修改菜品:{}",dishDTO);
         dishService.updateWithFlavor(dishDTO);
        return  Result.success();
    }
    @PostMapping("/status/{status}")
    @ApiOperation("修改菜品状态")
   public  Result status(@RequestParam Long id,@PathVariable Integer status ){
        log.info("修改菜品:{} {}",id,status);
        dishService.startOrStop(status,id);
        return Result.success();
    }
}

