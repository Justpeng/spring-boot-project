package com.just.dubbo.server.spi2;


import org.apache.dubbo.common.URL;

public class WechatOrder implements Order {
    @Override
    public String pay(URL url) {
        return "this is wechat order 2 pay";
    }

    @Override
    public String way() {
        return "this is alipay wechat 2 way";
    }
}
