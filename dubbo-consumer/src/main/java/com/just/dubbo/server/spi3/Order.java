package com.just.dubbo.server.spi3;

import org.apache.dubbo.common.extension.SPI;

@SPI("wechat")
public interface Order {

    String way();
}
