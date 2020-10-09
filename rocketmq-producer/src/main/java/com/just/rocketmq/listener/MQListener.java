package com.just.rocketmq.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

/**
 * 生产者事务监听.RocketMQTransactionListener 只能用于生产者，不能用于消费者
 */
@RocketMQTransactionListener
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class MQListener implements RocketMQLocalTransactionListener {


    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        log.info("msg:{},args:{}", msg, arg);
        return RocketMQLocalTransactionState.COMMIT;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        log.info("msg:{}", msg);
        return RocketMQLocalTransactionState.COMMIT;
    }
}
