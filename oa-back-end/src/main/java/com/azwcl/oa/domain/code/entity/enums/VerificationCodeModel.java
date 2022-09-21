package com.azwcl.oa.domain.code.entity.enums;

import lombok.Getter;

/**
 * 验证码模式
 *
 * @author az
 * @date 2022/09/19
 */

@Getter
public enum VerificationCodeModel {
    /**
     * 登录
     */
    LOGIN(0);

    /**
     * 模式
     */
    private final Integer model;

    VerificationCodeModel(Integer model) {
        this.model = model;
    }
}
