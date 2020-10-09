package com.just.rocketmq.consumer;

import com.just.rocketmq.domain.UserMsg;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        nameServer = "${demo.rocketmq.myNameServer}",
        topic = "${demo.rocketmq.topic.user}",
        consumerGroup = "user_consumer")
public class UserConsumer implements RocketMQListener<UserMsg> {
    @Override
    public void onMessage(UserMsg message) {
        System.out.printf("######## user_consumer received: %s ; age: %s ; name: %s \n", message, message.getUserAge(), message.getUserName());
    }
}
