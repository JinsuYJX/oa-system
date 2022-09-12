package com.azwcl.oa.infrastructure.common.exception;

import lombok.Getter;

/**
 * 自定义的断言异常
 * 用于进行应用处理时抛出的自定义异常
 *
 * @author az
 * @date 2022/09/12
 */

@Getter
public class AssertionException extends RuntimeException {

    /**
     * 错误代码
     */
    private final Integer code;

    /**
     * http 状态码
     */
    private final Integer httpStatus;

    /**
     * message 信息
     */
    private final String message;

    public AssertionException(Integer httpStatus, Integer code, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public AssertionException(Integer code, String message) {
        super(message);
        this.code = code;
        this.httpStatus = 500;
        this.message = message;
    }
}
