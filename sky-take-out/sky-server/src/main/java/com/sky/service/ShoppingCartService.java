package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    // 添加商品到购物车
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);
   /**
    * @description: 查看购物车
    * @author: X_X
    * @param: []
    * @return: java.util.List<com.sky.entity.ShoppingCart>
    **/
    List<ShoppingCart> showShoppingCart();

    void cleanShoppingCart();

    void subShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
