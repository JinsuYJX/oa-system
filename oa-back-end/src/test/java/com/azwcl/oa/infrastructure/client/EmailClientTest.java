package com.azwcl.oa.infrastructure.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

/**
 * 邮件客户端测试类
 *
 * @author az
 * @date 2022/09/11
 */
@SpringBootTest
public class EmailClientTest {
    @Autowired
    private EmailClient email;

    @Test
    public void sendSimpleMail() throws MessagingException {
        email.sendSimpleMail("1749402834@qq.com", "测试", "send");
    }
}
