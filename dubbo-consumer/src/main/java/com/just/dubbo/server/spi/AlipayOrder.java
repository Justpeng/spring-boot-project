package com.just.dubbo.server.spi;

public class AlipayOrder implements Order{
    @Override
    public void pay() {
        System.out.println("this is alipay");
    }
}
