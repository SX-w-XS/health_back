package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @BelongsProject: sky_test
 * @BelongsPackage: com.sky.config
 * @Author: X_X
 * @Description: redis配置类
 * @Version: 1.0
 */
@Configuration
@Slf4j
public class RedisConfiguration {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("redisTemplate bean init success");
        RedisTemplate redisTemplate = new RedisTemplate();
        // 设置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置key的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        return redisTemplate;
    }

}
