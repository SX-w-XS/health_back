package com.sky.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.task
 * @Author: X_X
 * @Description: 自定义任务类
 * @Version: 1.0
 */
@Component
@Slf4j
public class MyTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public  void executeTask(){
        log.info("任务启动：{}",new Date());
    }
}
