package com.azwcl.oa.infrastructure.common.exception;

import com.azwcl.oa.infrastructure.common.model.FailureResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
public class GlobalExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<?> exceptionHandler(Exception e) {
        if(e instanceof AssertionException) {
            log.info("global exception handle, code: {}, message: {} ", ((AssertionException) e).getCode(), e.getMessage());
            return ResponseEntity.status(((AssertionException) e).getHttpStatus()).body(new FailureResponseBody(((AssertionException) e).getCode(), e.getMessage()));
        }
        else {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(-999).body(e);
        }
    }
}
