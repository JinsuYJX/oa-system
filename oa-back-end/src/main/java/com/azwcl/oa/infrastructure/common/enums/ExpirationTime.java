package com.azwcl.oa.infrastructure.common.enums;

import lombok.Getter;

/**
 * 过期时间
 *
 * @author az
 * @date 2022/09/21
 */

@Getter
public enum ExpirationTime {

    /**
     * 验证码过期时间
     */
    VERIFICATION_CODE(300L);


    /**
     * 秒
     */
    private final Long second;

    /**
     * 毫秒
     */
    private final Long millisecond;

    ExpirationTime(Long second) {
        this.second = second;
        this.millisecond = second * 1000;
    }
}
