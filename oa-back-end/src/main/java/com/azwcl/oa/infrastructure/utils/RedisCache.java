package com.azwcl.oa.infrastructure.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * redis cache 操作工具
 *
 * @author az
 * @date 2022/09/19
 */

@Component
@RequiredArgsConstructor
public class RedisCache {
    private final RedisTemplate<String, Object> redisTemplate;


    /**
     * 设置 hash 数据
     *
     * @param key   redis 键
     * @param hKey  hash 键
     * @param value hash 值
     */
    public void setHashValue(String key, Object hKey, Object value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取 hash 数据
     *
     * @param key  redis 键
     * @param hKey hash 键
     * @return hash 值
     */
    public Object getHashValue(String key, Object hKey) {
        return redisTemplate.opsForHash().get(key, hKey);
    }

    /**
     * 获取 hash 数据
     *
     * @param key  redis 键
     * @param hKey hash 键
     * @return hash 值
     */
    public List<Object> getHashValue(String key, Collection<Object> hKey) {
        return redisTemplate.opsForHash().multiGet(key, hKey);
    }

    /**
     * 删除 hash 值
     *
     * @param key  redis 键
     * @param hKey hash 键
     */
    public void deleteHashValue(String key, Object hKey) {
        redisTemplate.opsForHash().delete(key, hKey);
    }
}
