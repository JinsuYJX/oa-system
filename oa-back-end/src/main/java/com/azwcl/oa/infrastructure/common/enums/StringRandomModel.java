package com.azwcl.oa.infrastructure.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 字符串随机模式
 *
 * @author az
 * @date 2022/09/08
 */

@AllArgsConstructor
@Getter
public enum StringRandomModel {
    /**
     * 未知
     */
    NONE(-1),

    /**
     * 所有字符都存在的随机串
     */
    ALL(0),

    /**
     * 仅数字
     */
    ONLY_NUMBER(1),

    /**
     * 仅字符
     */
    ONLY_CHARACTER(2);

    /**
     * 字符串随机模式
     */
    public final Integer model;

    /**
     * of 方法
     *
     * @param model 需要判断的模式
     * @return 返回所属模式
     */
    public StringRandomModel of(Integer model) {
        StringRandomModel[] values = values();

        for (StringRandomModel value : values) {
            if (value.getModel().equals(model)) {
                return value;
            }
        }

        return NONE;

    }
}
