package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.ShoppingCart;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.mapper.ShoppingCartMapper;
import com.sky.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.service.impl
 * @Author: X_X
 * @Description:  用户购物车
 * @Version: 1.0
 */
@Service
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;
    @Autowired
    DishMapper dishMapper;
    @Autowired
    SetmealMapper setmealMapper;

    /**
     * @description:添加购物车
     * @author: X_X
     * @param: [shoppingCartDTO]
     * @return: void
     **/
    @Override
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        //判断是否存在商品
        ShoppingCart shoppingCart=new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO,shoppingCart);
        Long userId= BaseContext.getCurrentId();
        shoppingCart.setUserId(userId);
        List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);
        //如果存在 则加一
        if(list !=null &&list.size()>0){
            ShoppingCart cart=list.get(0);
            cart.setNumber(cart.getNumber()+1);
            shoppingCartMapper.updateNumberById(cart);
        }else {
        //不存在则添加
            Long dishId = shoppingCart.getDishId();
            if(dishId != null){
                Dish byId = dishMapper.getById(dishId);
                shoppingCart.setName(byId.getName());
                shoppingCart.setAmount(byId.getPrice());
                shoppingCart.setImage(byId.getImage());
          }else {
                Long setmealId = shoppingCart.getSetmealId();
                Setmeal byId = setmealMapper.getById(setmealId);
                shoppingCart.setName(byId.getName());
                shoppingCart.setAmount(byId.getPrice());
                shoppingCart.setImage(byId.getImage());
            }
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartMapper.insert(shoppingCart);

}
    }

    /**
     * @description: 查看购物车
     * @author: X_X
     * @param: []
     * @return: java.util.List<com.sky.entity.ShoppingCart>
     **/
    @Override
    public List<ShoppingCart> showShoppingCart() {
        Long userId= BaseContext.getCurrentId();
        ShoppingCart build = ShoppingCart.builder()
                .id(userId)
                .build();
        List<ShoppingCart> list = shoppingCartMapper.list(build);
        return list;
    }
  /**
   * @description: 清空购物车
   * @author: X_X
   * @param: []
   * @return: void
   **/
    @Override
    public void cleanShoppingCart() {
        shoppingCartMapper.deleteByUserId(BaseContext.getCurrentId());
    }
   /**
    * @description: 修改商品
    * @author: X_X
    * @param: [shoppingCartDTO]
    * @return: void
    **/
    @Override
    public void subShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO,shoppingCart);

        shoppingCart.setUserId(BaseContext.getCurrentId());
        List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);

        if(list != null && list.size() > 0){
            shoppingCart = list.get(0);

            Integer number = shoppingCart.getNumber();
            if(number == 1){
                //当前商品在购物车中的份数为1，直接删除当前记录
                shoppingCartMapper.deleteById(shoppingCart.getId());
            }else {
                //当前商品在购物车中的份数不为1，修改份数即可
                shoppingCart.setNumber(shoppingCart.getNumber() - 1);
                shoppingCartMapper.updateNumberById(shoppingCart);
            }
        }
    }
}
