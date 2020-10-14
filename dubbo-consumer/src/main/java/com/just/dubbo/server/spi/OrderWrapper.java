package com.just.dubbo.server.spi;

public class OrderWrapper implements Order{

    private Order order;

    public OrderWrapper(Order order) {
        this.order = order;
    }



    @Override
    public void pay() {
        System.out.println("this is wrapper start");
        order.pay();
        System.out.println("this is wrapper end");
    }
}
