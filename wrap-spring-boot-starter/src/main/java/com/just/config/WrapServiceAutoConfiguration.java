package com.just.config;

import com.just.service.WrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2 自动配置类
 */
@Configuration
@ConditionalOnClass(WrapService.class)
@EnableConfigurationProperties(WrapServiceProperties.class)
public class WrapServiceAutoConfiguration {

    @Autowired
    private WrapServiceProperties wrapServiceProperties;

    /**
     * 注意与wrapService()的顺序
     * @return
     */
    @Bean
//    @ConditionalOnProperty(name = "just.wrap.enabled",havingValue = "true",matchIfMissing = true)
    @ConditionalOnProperty(name = "just.wrap.enabled",matchIfMissing = true)
    public WrapService wrapService2() {
        return new WrapService(wrapServiceProperties.getPrefix(), wrapServiceProperties.getSuffix());
    }

    @Bean
    @ConditionalOnMissingBean
    public WrapService wrapService() {
        return new WrapService("", "");
    }
}
