package com.alperenikinci.config.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableCaching // redis üzerinde kullanmak üzere spring cache in aktif edilmesi için gereklidir.
@EnableRedisRepositories
public class RedisConfiguration {

    public LettuceConnectionFactory redisLettuceConnectionFactory(){
        return new LettuceConnectionFactory(
                new RedisStandaloneConfiguration("localhost",6379));
    }


}
