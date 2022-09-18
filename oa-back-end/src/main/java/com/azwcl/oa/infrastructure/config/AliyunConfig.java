package com.azwcl.oa.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云的配置
 *
 * @author az
 * @date 2022/09/18
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "aliyun")
public class AliyunConfig {

    /**
     * 阿里云 key
     */
    private String accessKeyId;

    /**
     * 阿里云 secret
     */
    private String accessKeySecret;
}
