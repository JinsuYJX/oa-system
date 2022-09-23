package com.azwcl.oa.infrastructure.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * redis cache 操作工具
 *
 * @author az
 * @date 2022/09/19
 */

@Component
@RequiredArgsConstructor
public class RedisCache {
    private final RedisTemplate<String, String> redisTemplate;

    private final JsonSerialize jsonSerialize;

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
    public  <T> T getHashValue(String key, Object hKey, Class<T> clazz) {
        Object o = redisTemplate.opsForHash().get(key, hKey);

        if(Objects.isNull(o)) {
            return null;
        }

        return jsonSerialize.readValue(o, clazz);
    }

    /**
     * 获取 hash 数据
     *
     * @param key  redis 键
     * @param hKey hash 键
     * @return hash 值
     */
    public <T> List<T> getHashValue(String key, Collection<Object> hKey, Class<T> clazz) {
        List<Object> objects = redisTemplate.opsForHash().multiGet(key, hKey);

        return objects
                .stream()
                .map(obj -> jsonSerialize.readValue(obj, clazz))
                .collect(Collectors.toList());
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
