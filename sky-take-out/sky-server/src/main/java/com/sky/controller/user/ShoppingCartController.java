package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
   @GetMapping("/list")
   @ApiOperation("查看购物车")
   public Result<List<ShoppingCart>> list(){
        List<ShoppingCart> shoppingCarts=shoppingCartService.showShoppingCart();
        return  Result.success(shoppingCarts);
   }
   @DeleteMapping("/clean")
   @ApiOperation("清空购物车")
   public Result clean(){
          shoppingCartService.cleanShoppingCart();
       return Result.success();
   }
   @PostMapping("/sub")
   @ApiOperation("减少商品")
   public  Result sub(@RequestBody ShoppingCartDTO shoppingCartDTO){
       log.info("本次商品为：" ,shoppingCartDTO);
       shoppingCartService.subShoppingCart(shoppingCartDTO);
       return  Result.success();
   }

}
