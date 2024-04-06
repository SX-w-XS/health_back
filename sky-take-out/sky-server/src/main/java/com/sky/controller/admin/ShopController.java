package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;


/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.controller.admin
 * @Author: X_X
 * @Description: 商店管理
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关操作")
@Slf4j
public class ShopController {
    public static final String KEY_SHOP_STATUS = "shop_status";

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * @description:设置店铺营业状态
     * @author: X_X
     * @param: [status]
     * @return: com.sky.result.Result
     **/
     @PutMapping("/{status}")
     @ApiOperation("设置店铺营业状态")
     public Result setStatus(@PathVariable Integer status ){
         log.info("设置店铺营业状态为：{}",status==1?"营业中":"打烊");
         redisTemplate.opsForValue().set(KEY_SHOP_STATUS,status);
         return Result.success();
     }

     @GetMapping("/status")
     @ApiOperation("查询店铺状态")
     public Result<Integer> getStatus(){
         Integer status = (Integer) redisTemplate.opsForValue().get(KEY_SHOP_STATUS);
         log.info("查询店铺状态:{}",status);
         return Result.success(status);

     }

}
