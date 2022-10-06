package com.azwcl.oa.domain.person.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 用户认证类型
 *
 * @author az
 * @date 2022/10/02
 */

@Getter
@RequiredArgsConstructor
public enum PersonAuthType {
    /**
     * 邮件密码登录
     */
    EMAIL_PASSWORD(1);

    private final Integer type;
}
