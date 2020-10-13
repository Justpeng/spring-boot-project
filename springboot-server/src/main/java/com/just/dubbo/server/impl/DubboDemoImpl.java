package com.just.dubbo.server.impl;

import com.just.dubbo.client.DubboDemo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
@Slf4j
public class DubboDemoImpl implements DubboDemo {
    @Override
    public String sayHello() {
        return "ni hao!";
    }
}
