package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
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
 * @BelongsPackage: com.sky.controller.user
 * @Author: X_X
 * @Description: 购物车模块
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "购物车")
public class ShoppingCartController {

    @Autowired
   ShoppingCartService shoppingCartService;

   @PostMapping("/add")
   @ApiOperation("添加购物车")
   public Result  add(@RequestBody ShoppingCartDTO shoppingCartDTO){
      log.info("添加购物车，商品信息：{}" ,shoppingCartDTO);

      // 添加购物车逻辑
       shoppingCartService.addShoppingCart(shoppingCartDTO);
      return  Result.success();
   }
}
