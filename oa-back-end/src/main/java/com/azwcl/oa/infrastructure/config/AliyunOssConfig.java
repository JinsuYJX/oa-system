package com.azwcl.oa.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云 oss 配置
 *
 * @author az
 * @date 2022/09/18
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "file-system.aliyun-oss")
public class AliyunOssConfig {
    /**
     * oss end point
     */
    private String endPoint;

    /**
     * oss 的 bucket name
     */
    private String bucketName;

    /**
     * oss 的基础读写路径
     */
    private String dataPath;
}
