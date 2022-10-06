package com.azwcl.oa.domain.code.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

/**
 * code 种类
 *
 * @author az
 * @date 2022/09/28
 */

@Getter
@RequiredArgsConstructor
public enum CodeType {
    /**
     * none
     */
    NONE(-1),

    /**
     * 登录验证码
     */
    LOGIN(0);

    private final Integer type;

    /**
     * 枚举 of 方法
     *
     * @param type 类型
     * @return 返回枚举类
     */
    public CodeType of(Integer type) {
        CodeType[] values = values();

        for (CodeType value : values) {
            if (Objects.equals(value.getType(), type)) {
                return value;
            }
        }

        return NONE;

    }
}
