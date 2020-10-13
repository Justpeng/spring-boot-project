package com.just.dubbo.client;

import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("just/provider")
public interface DubboProviderDemo {
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
