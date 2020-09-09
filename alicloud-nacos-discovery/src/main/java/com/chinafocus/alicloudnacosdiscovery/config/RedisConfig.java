package com.chinafocus.alicloudnacosdiscovery.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

import java.time.Duration;

@RefreshScope
@EnableRedisHttpSession
@Configuration
public class RedisConfig {

    /**
     * sessionId通过header获取
     * @return
     */
    @Bean
    public HttpSessionIdResolver httpSessionStrategy(){
        return new HeaderHttpSessionIdResolver("x-auth-token");
    }

    /**
     * @Autowired注入 默认这个配置
     */

    @Primary
    @Bean("redisTemplate2")
    public RedisTemplate<String, Object> redisTemplate2(@Value("${spring.redis2.database}") int database,
                                                        @Value("${spring.redis.timeout}") long timeout,
                                                        @Value("${spring.redis.lettuce.pool.max-active}") int maxActive,
                                                        @Value("${spring.redis.lettuce.pool.max-wait}") int maxWait,
                                                        @Value("${spring.redis.lettuce.pool.max-idle}") int maxIdle,
                                                        @Value("${spring.redis.lettuce.pool.min-idle}") int minIdle,
                                                        @Value("${spring.redis2.host}") String hostName,
                                                        @Value("${spring.redis2.port}") int port,
                                                        @Value("${spring.redis2.password}") String password) {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(hostName);
        configuration.setPort(port);
        configuration.setDatabase(database);
        if (!ObjectUtils.isEmpty(password)) {
            RedisPassword redisPassword = RedisPassword.of(password);
            configuration.setPassword(redisPassword);
        }
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(maxActive);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMaxWaitMillis(maxWait);
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
        builder.poolConfig(genericObjectPoolConfig);
        builder.commandTimeout(Duration.ofSeconds(timeout));
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(configuration, builder.build());
        connectionFactory.afterPropertiesSet();
        return getRedisTemplate(connectionFactory);
    }

    /**
     * session
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String,Object> redisTemplate = getRedisTemplate(redisConnectionFactory);
        return redisTemplate;
    }

    public RedisTemplate getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        //设置序列化接口
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.setDefaultFilter(SimpleBeanPropertyFilter.serializeAll());
        mapper.setFilterProvider(filterProvider);
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer(mapper);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


}
