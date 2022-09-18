package com.azwcl.oa.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 文件系统配置
 *
 * @author az
 * @date 2022/09/18
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "file-system")
public class FileSystemConfig {
    /**
     * 文件系统模式
     */
    private Integer mode;
}
