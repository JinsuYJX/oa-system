package com.azwcl.oa.infrastructure.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 布尔值
 *
 * @author az
 * @date 2022/09/25
 */

@Getter
@AllArgsConstructor
public enum BooleanValue {
    /**
     * true
     */
    TRUE(1, "1"),

    /**
     * false
     */
    FALSE(0, "0");

    /**
     * int 值
     */
    private final Integer valueInt;

    /**
     * string 值
     */
    private final String valueString;
}
