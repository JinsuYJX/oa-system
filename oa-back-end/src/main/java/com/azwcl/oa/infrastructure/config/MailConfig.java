package com.azwcl.oa.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 邮件配置
 *
 * @author az
 * @date 2022/09/18
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailConfig {
    /**
     * 主机
     */
    private String host;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 发件人
     */
    private String from;
}
