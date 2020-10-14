package com.just.test;

import com.alibaba.fastjson.JSONObject;
import com.just.dubbo.server.spi.AdaptiveOrder;
import com.just.dubbo.server.spi.Order;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.Set;

public class DubboSPITest {

    @Test
    public void test01() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);

        Order alipay = loader.getExtension("alipay");
        alipay.pay();

        Order wechat = loader.getExtension("wechat");
        wechat.pay();

    }

    @Test
    public void test02() {
        ExtensionLoader<Order> extensionLoader = ExtensionLoader.getExtensionLoader(Order.class);
        Order adaptiveExtension = extensionLoader.getAdaptiveExtension();
        adaptiveExtension.pay();
    }

    @Test
    public void test03() {
        ExtensionLoader<Order> extensionLoader = ExtensionLoader.getExtensionLoader(Order.class);
        Order adaptive = extensionLoader.getAdaptiveExtension();
        ((AdaptiveOrder)adaptive).setAdaptiveName("alipay");
        adaptive.pay();
    }

    @Test
    public void test04() {
        //adaptive是不包含在扩展类里的
        ExtensionLoader<Order> extensionLoader = ExtensionLoader.getExtensionLoader(Order.class);
        Set<String> strings = extensionLoader.getLoadedExtensions();
        System.out.println(JSONObject.toJSON(strings));

    }

    /**
     * adaptive 和 wrapper都不属于扩展类，不能单独使用
     */
    @Test
    public void test05() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        Set<String> strings = loader.getSupportedExtensions();
        System.out.println(strings);
    }
}
