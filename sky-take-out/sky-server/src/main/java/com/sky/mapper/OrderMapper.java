package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.mapper
 * @Author: X_X
 * @Description: 订单表
 * @Version: 1.0
 */
@Mapper
public interface OrderMapper  {
    /**
     * @description:插入数据
     * @author: X_X
     * @param: []
     * @return: void
     **/
    public void insert(Orders orders) ;

    /**
     * 根据订单号查询订单
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 分页条件查询并按下单时间排序
     * @param ordersPageQueryDTO
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 根据id查询订单
     * @param id
     */
    @Select("select * from orders where id=#{id}")
    Orders getById(Long id);

    /**
     * 根据状态统计订单数量
     * @param status
     */
    @Select("select count(id) from orders where status = #{status}")
    Integer countStatus(Integer status);

    /**
     * @description:根据状态和下单时间查询订单
     * @author: X_X
     * @param: [status, orderTime]
     * @return: java.util.List<com.sky.entity.Orders>
     **/
    @Select("select * from orders where status = #{status} and order_time < #{orderTime}")
    List<Orders>  getByStatusAndOrderTimeLT(Integer status , LocalDateTime orderTime);
}
