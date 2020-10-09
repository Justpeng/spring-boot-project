package com.just.rocketmq.consumer;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        topic = "${demo.rocketmq.bytesRequestTopic}",
        consumerGroup = "bytesRequestConsumer",
        selectorExpression = "${demo.rocketmq.tag}")
public class ConsumerWithReplyBytes implements RocketMQReplyListener<MessageExt, byte[]> {
    @Override
    public byte[] onMessage(MessageExt message) {
        System.out.printf("------- ConsumerWithReplyBytes received: %s \n", message);
        return "reply message content".getBytes();
    }
}
