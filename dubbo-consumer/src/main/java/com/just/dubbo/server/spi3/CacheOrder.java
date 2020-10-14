package com.just.dubbo.server.spi3;

import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"offline","online"},order = 4)
public class CacheOrder implements Order {
    @Override
    public String way() {
        return "cache way";
    }
}
