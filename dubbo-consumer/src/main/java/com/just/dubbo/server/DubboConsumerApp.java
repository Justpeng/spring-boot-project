package com.just.dubbo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lipeng
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DubboConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApp.class, args);
    }
}