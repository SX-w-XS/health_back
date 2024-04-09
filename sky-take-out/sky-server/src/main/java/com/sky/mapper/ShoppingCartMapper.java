package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.mapper
 * @Author: X_X
 * @Description: 购物车
 * @Version: 1.0
 */
@Mapper
public interface ShoppingCartMapper {
    /**
     * @description: 动态查询
     * @author: X_X
     * @param: [shoppingCart]
     * @return: java.util.List<com.sky.entity.ShoppingCart>
     **/
    List<ShoppingCart>  list(ShoppingCart shoppingCart);
    /**
     * @description:根据id修改商品数量
     * @author: X_X
     * @param: [shoppingCart]
     * @return: void
     **/
   @Update("update  shopping_cart set  number =#{number} where id=#{id}")
    void updateNumberById(ShoppingCart shoppingCart);
   /**
    * @description: 插入购物车
    * @author: X_X
    * @param: [shoppingCart]
    * @return: void
    **/
   @Insert("insert into shopping_cart(name, image, user_id, dish_id, setmeal_id, dish_flavor, amount, create_time) " +
           "values (#{name},#{image},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{amount},#{createTime})")
    void insert(ShoppingCart shoppingCart);
}
