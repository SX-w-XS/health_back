package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.config
 * @Author: X_X
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
@Slf4j
public class OssConfiguration {
   @Bean
   @ConditionalOnMissingBean
    public AliOssUtil  aliOssUtil(AliOssProperties aliOssProperties){
        log.info("创建文件上传类：{}",aliOssProperties);
        return    new AliOssUtil(aliOssProperties.getEndpoint(),aliOssProperties.getAccessKeyId(),aliOssProperties.getAccessKeySecret()
          ,aliOssProperties.getBucketName());
    }

}
