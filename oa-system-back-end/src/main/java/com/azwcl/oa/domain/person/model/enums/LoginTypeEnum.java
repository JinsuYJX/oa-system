package com.azwcl.oa.domain.person.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 登录类型
 *
 * @author az
 * @date 2022/09/30
 */

@Getter
@RequiredArgsConstructor
public enum LoginTypeEnum {
    /**
     * web 登录
     */
    WEB(0);


    private final Integer type;
}
