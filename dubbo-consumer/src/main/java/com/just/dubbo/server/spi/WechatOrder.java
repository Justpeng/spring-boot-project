package com.just.dubbo.server.spi;

public class WechatOrder implements Order{
    @Override
    public void pay() {
        System.out.println("this is wechat pay");
    }
}
