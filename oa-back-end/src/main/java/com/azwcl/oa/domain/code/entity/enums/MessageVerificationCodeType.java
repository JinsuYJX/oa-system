package com.azwcl.oa.domain.code.entity.enums;

import lombok.Getter;

/**
 * 信息验证码类型
 *
 * @author az
 * @date 2022/09/21
 */

@Getter
public enum MessageVerificationCodeType {

    /**
     * 未知
     */
    UNKNOWN(-1),
    /**
     * 邮件信息验证码
     */
    EMAIL(0);

    /**
     * 类型
     */
    private final Integer type;

    MessageVerificationCodeType(Integer type) {
        this.type = type;
    }
}
