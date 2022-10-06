package com.azwcl.oa.infrastructure.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * message source 工具类
 *
 * @author az
 * @date 2022/09/22
 */
@Component
@Slf4j
public class MessageSourceUtil {
    public final Locale DEFAULT_LOCALE = Locale.CHINA;

    public MessageSource messageSource;

    public MessageSourceUtil(MessageSource source) {
        this.messageSource = source;
    }

    /**
     * 获取 message
     *
     * @param code 代码
     * @param args 参数
     * @return message
     */
    public String getMessage(String code, Object... args) {
        // 目前限制死中文
        return messageSource.getMessage(code, args, Locale.CHINA);
    }

    /**
     * 获取 message
     *
     * @param code 代码
     * @return message
     */
    public String getMessage(String code) {
        return getMessage(code, (Object) null);
    }
}