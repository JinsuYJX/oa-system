package com.azwcl.oa.infrastructure.config;

import com.azwcl.oa.infrastructure.common.model.FailureResponseBody;
import com.azwcl.oa.infrastructure.exception.AssertionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author az
 * @date 2022/09/12
 */

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<?> exceptionHandler(Exception e) {
        if(e instanceof AssertionException) {
            log.info("global exception handle, code: {}, message: {} ", ((AssertionException) e).getCode(), e.getMessage());
            return ResponseEntity.status(((AssertionException) e).getHttpStatus()).body(new FailureResponseBody(((AssertionException) e).getCode(), e.getMessage()));
        }
        else if(e instanceof HttpRequestMethodNotSupportedException) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED.value()).build();
        }
        else {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
        }
    }
}