package org.demo.springCloud.redis;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableCaching
//@AutoConfigureAfter(RedisConfig.class)

public class RedisConfig extends CachingConfigurerSupport {
    public RedisConfig() {
        System.out.println("RedisConfig======初始化！" + DateUtil.today());
    }


//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        @SuppressWarnings({"rawtypes", "unchecked"})
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }

//    @Resource
//    private LettuceConnectionFactory lettuceConnectionFactory;
//
//    @Bean
//    public KeyGenerator keyGenerator() {
//
//        return new KeyGenerator() {
//
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//
//                StringBuffer sb = new StringBuffer();
//
//                sb.append(target.getClass().getName());
//
//                sb.append(method.getName());
//
//                for (Object obj : params) {
//
//                    sb.append(obj.toString());
//
//                }
//
//                return sb.toString();
//
//            }
//
//        };
//
//    }
//
//    // 缓存管理器
//
//    @Bean
//    public CacheManager cacheManager() {
//
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder
//
//                .fromConnectionFactory(lettuceConnectionFactory);
//        @SuppressWarnings("serial")
//        Set<String> cacheNames = new HashSet<String>() {
//            {
//                add("codeNameCache");
//            }
//        };
//        builder.initialCacheNames(cacheNames);
//        return builder.build();
//
//    }
//
//    @Bean
//    public RedisTemplate<String, Serializable> redisCacheTemplate(
//            redisConnectionFactory) {
//
//        RedisTemplate<String, Serializable> template = new RedisTemplate<String, Serializable>();
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());// Hash key序列化
//        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());// Hash value序列化
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }

}