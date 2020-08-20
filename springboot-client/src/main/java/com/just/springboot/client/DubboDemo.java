package com.just.springboot.client;

import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("dubbo")
public interface DubboDemo{
    /**
     * 测试
     * * @return
     */
    @POST
    @Path("hello")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    @Consumes(ContentType.APPLICATION_JSON_UTF_8)
    String sayHello();
}
