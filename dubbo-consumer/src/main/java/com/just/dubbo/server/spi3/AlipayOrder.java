package com.just.dubbo.server.spi3;

import org.apache.dubbo.common.extension.Activate;

@Activate(group = "online",value = "alipay")
public class AlipayOrder implements Order{
    @Override
    public String way() {
        return "alipay way";
    }
}
