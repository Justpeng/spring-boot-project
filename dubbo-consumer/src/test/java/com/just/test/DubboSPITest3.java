package com.just.test;

import com.just.dubbo.server.spi3.Order;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class DubboSPITest3 {

    @Test
    public void test() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        URL url = URL.valueOf("xxx://localhost/ooo");
        List<Order> orderList=  loader.getActivateExtension(url, "offline");
        orderList.stream().forEach(f-> System.out.println(f.way()));

    }

    @Test
    public void test01() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        URL url = URL.valueOf("xxx://localhost/ooo");
        List<Order> orderList=  loader.getActivateExtension(url, "online");
        orderList.stream().forEach(f -> System.out.println(f.way()));
    }

    @Test
    public void test02() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        URL url = URL.valueOf("xxx://localhost/ooo?key=wechat");
        //group = online or key = wechat ,对于Activate类是并且的关系，所以只有wechatOrder激活
        List<Order> orderList=  loader.getActivateExtension(url, "key","online");
        orderList.stream().forEach(f -> System.out.println(f.way()));
    }

    @Test
    public void test03() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        URL url = URL.valueOf("xxx://localhost/ooo?key=wechat");
        Set<String> stringSet = loader.getSupportedExtensions();
        System.out.println(stringSet);
    }
}
