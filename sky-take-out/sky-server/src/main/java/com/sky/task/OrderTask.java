package com.sky.task;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.task
 * @Author: X_X
 * @Description: 订单超时任务
 * @Version: 1.0
 */
@Component
@Slf4j
public class OrderTask {

    @Autowired
    private OrderMapper orderMapper;
    
     /*
      * @description:订单超时
      * @author: X_X
      * @param: []
      * @return: void
      */
    @Scheduled(cron = "0 * * * * ?")
    public  void processTimeoutOrder(){
        log.info("订单超时:{}",new Date());

        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(-15);
        List<Orders> orderList = orderMapper.getByStatusAndOrderTimeLT(Orders.PENDING_PAYMENT, localDateTime);

        if(orderList.size()>0&&orderList!=null){
            for (Orders order:orderList) {
                order.setStatus(Orders.CANCELLED);
                order.setCancelReason("超时");
                order.setCancelTime(LocalDateTime.now());
                orderMapper.update(order);
            }
        }
        
      }
      /**
       * @description:处理派送订单
       * @author: X_X
       * @param: []
       * @return: void
       **/
      @Scheduled(cron = "0 0 1 * * ?")
      public  void  processTimeoutOrder1(){
          log.info("处理派送订单:{}",new Date());
          LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(-15);
          List<Orders> orderList = orderMapper.getByStatusAndOrderTimeLT(Orders.DELIVERY_IN_PROGRESS, localDateTime);

          if(orderList.size()>0&&orderList!=null){
              for (Orders order:orderList) {
                  order.setStatus(Orders.COMPLETED);
                  orderMapper.update(order);
              }
          }
      }

}
