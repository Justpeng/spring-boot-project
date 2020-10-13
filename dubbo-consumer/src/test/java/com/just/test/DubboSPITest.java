package com.just.test;

import com.just.dubbo.server.spi.AdaptiveOrder;
import com.just.dubbo.server.spi.Order;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

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

}
