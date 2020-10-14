package com.just.dubbo.server.spi;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.utils.StringUtils;

@Adaptive
public class AdaptiveOrder implements Order {

    private String adaptiveName;

    public void setAdaptiveName(String adaptiveName) {
        this.adaptiveName = adaptiveName;
    }

    @Override
    public void pay() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        Order order;
        if (StringUtils.isEmpty(adaptiveName)) {
            order = loader.getDefaultExtension();
        }else {
            order = loader.getExtension(adaptiveName);
        }
        order.pay();
    }
}
