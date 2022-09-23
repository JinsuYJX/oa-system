package com.azwcl.oa.infrastructure.utils;

import com.azwcl.oa.infrastructure.common.exception.AssertionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * json 序列化
 *
 * @author az
 * @date 2022/09/22
 */

@Component
@RequiredArgsConstructor
public class JsonSerialize {
    private final ObjectMapper objectMapper;

    private final MessageSourceUtil messageSourceUtil;

    /**
     * 反序列化对象字符串
     *
     * @param o     Object
     * @param clazz Object.class
     * @param <T>   模板
     * @return 反序列化对象
     */
    public <T> T readValue(Object o, Class<T> clazz) {
        try {
            String s = o.toString();
            return objectMapper.readValue(s, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new AssertionException(200000, messageSourceUtil.getMessage("200000"));
        }
    }

    /**
     * 获取 json 字符串
     *
     * @param o Object
     * @return json string
     */
    public String getJson(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new AssertionException(200000, messageSourceUtil.getMessage("200000"));
        }
    }
}
