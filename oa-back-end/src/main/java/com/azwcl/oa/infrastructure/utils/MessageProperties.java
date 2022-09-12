package com.azwcl.oa.infrastructure.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 消息配置工具
 *
 * @author az
 * @date 2022/09/12
 */

@RequiredArgsConstructor
@Component
public class MessageProperties {
    private final Properties properties;

    /**
     * 构造函数
     * @throws IOException io 异常
     */
    public MessageProperties() throws IOException {
        this.properties = new Properties();
        InputStream stream = ClassLoader.getSystemResourceAsStream("config/message.properties");

        assert stream != null;

        InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);


        this.properties.load(reader);

        reader.close();
        stream.close();
    }

    /**
     * 获取消息配置
     *
     * @param code 消息代码
     * @return 消息配置内容
     */
    public String getMessage(Integer code) {
        return this.properties.getProperty(String.valueOf(code));
    }
}
