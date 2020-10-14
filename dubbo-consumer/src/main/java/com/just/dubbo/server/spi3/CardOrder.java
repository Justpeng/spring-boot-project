package com.just.dubbo.server.spi3;

import org.apache.dubbo.common.extension.Activate;

@Activate(group = "offline", order = 3)
public class CardOrder implements Order {
    @Override
    public String way() {
        return "card way";
    }
}
