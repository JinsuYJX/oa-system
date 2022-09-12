package com.azwcl.oa.infrastructure.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试
 *
 * @author az
 * @date 2022/09/12
 */
@SpringBootTest
@Slf4j
public class MessagePropertiesTest {
    @Autowired
    private MessageProperties messageProperties;

    @Test
    public void getMessage() {
        String message = this.messageProperties.getMessage(200000);
        log.info(message);
    }
}
