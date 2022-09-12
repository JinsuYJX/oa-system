package com.azwcl.oa.infrastructure.common.enums;

import lombok.Getter;

/**
 * 响应状态码
 *
 * @author az
 * @date 2022/09/12
 */

@Getter
public enum ResponseStatusCode {

    /**
     * 200
     */
    SUCCESS(200, "成功"),

    /**
     * 201
     */
    CREATED(201, "已创建"),

    /**
     * 202
     */
    ACCEPTED(202, "已接受"),

    /**
     * 400
     */
    BAD_REQUEST(400, "客户端请求语法错误"),

    /**
     * 401
     */
    UNAUTHORIZED(401, "身份未认证"),

    /**
     * 500
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    /**
     * 响应状态码
     */
    private final Integer httpStatus;

    /**
     * 状态码消息解释
     */
    private final String message;

    ResponseStatusCode(Integer httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
