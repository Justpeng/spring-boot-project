package com.just.dubbo.server.service;

import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("just/consumer")
public interface DubboConsumer {
    /**
     * 测试
     * * @return
     */
    @POST
    @Path("call")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    @Consumes(ContentType.APPLICATION_JSON_UTF_8)
    String sayHelloTest();
}
