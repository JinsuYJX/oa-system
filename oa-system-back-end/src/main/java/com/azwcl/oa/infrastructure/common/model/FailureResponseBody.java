package com.azwcl.oa.infrastructure.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 脱离业务；失败返回body
 *
 * @author az
 * @date 2022/09/12
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FailureResponseBody {
    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;
}