package com.just.dubbo.server.spi2;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("wechat")
public interface Order {
    @Adaptive
    String pay(URL url);

    String way();
}
