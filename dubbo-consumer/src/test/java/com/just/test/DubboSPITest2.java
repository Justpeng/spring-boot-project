package com.just.test;

import com.just.dubbo.server.spi2.Order;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class DubboSPITest2 {

    @Test
    public void test01() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        Order adaptiveOrder = loader.getAdaptiveExtension();
        URL url = URL.valueOf("xxx://localhost/ooo");
        System.out.println(adaptiveOrder.pay(url));

    }

    @Test
    public void test02() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        Order adaptiveOrder = loader.getAdaptiveExtension();
        URL url = URL.valueOf("xxx://localhost/ooo?order.pay=alipay");
        System.out.println(adaptiveOrder.pay(url));

    }

}
