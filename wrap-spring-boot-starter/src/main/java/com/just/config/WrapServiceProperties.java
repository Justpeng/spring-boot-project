package com.just.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 3
 * 配置文件中属性的封装类
 * 要读取并封装如下属性：
 * just.wrap.prefix
 * just.wrap.suffix
 */
@Data
@ConfigurationProperties(prefix = "just.wrap")
public class WrapServiceProperties {
    private String prefix;

    private String suffix;
}
