package com.just.dubbo.server.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI("wechat")
public interface Order {
    void pay();
}
