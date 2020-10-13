package com.just.dubbo.server.impl;

import com.just.dubbo.client.DubboProviderDemo;
import com.just.dubbo.server.service.DubboConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
@Slf4j
public class DubboConsumerImpl implements DubboConsumer {

    @Resource
    private DubboProviderDemo dubboProviderDemo;

    @Override
    public String sayHelloTest() {
        return dubboProviderDemo.sayHello();
    }
}
