package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.mapper
 * @Author: X_X
 * @Description: 订单明细表
 * @Version: 1.0
 */
@Mapper
public interface OrderDetailMapper {

    public void insertBatch(List<OrderDetail> ordersList);
}
