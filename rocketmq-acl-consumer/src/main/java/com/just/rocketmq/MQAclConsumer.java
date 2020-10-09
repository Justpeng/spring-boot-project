package com.just.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MQAclConsumer {
    public static void main(String[] args) {
        SpringApplication.run(MQAclConsumer.class,args);
    }
}
