package com.just.dubbo.server.spi3;

import org.apache.dubbo.common.extension.Activate;

/**
 * group 与 value 一起存在时，是并且的关系
 */
@Activate(group = "online",value = "wechat")
public class WechatOrder implements Order{
    @Override
    public String way() {
        return "wechat way";
    }
}
