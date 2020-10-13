package com.just.test;

import com.just.dubbo.server.spi2.OrderPay;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class DubboSPITest2 {

    @Test
    public void test01() {
        ExtensionLoader<OrderPay> loader = ExtensionLoader.getExtensionLoader(OrderPay.class);
        OrderPay adaptiveOrderPay = loader.getAdaptiveExtension();
        URL url = URL.valueOf("xxx://localhost/ooo");
        System.out.println(adaptiveOrderPay.pay(url));

    }

    @Test
    public void test02() {
        ExtensionLoader<OrderPay> loader = ExtensionLoader.getExtensionLoader(OrderPay.class);
        OrderPay adaptiveOrderPay = loader.getAdaptiveExtension();
        URL url = URL.valueOf("xxx://localhost/ooo?order.pay=alipay");
        System.out.println(adaptiveOrderPay.pay(url));

    }

}
