package com.just.rocketmq;
import com.alibaba.fastjson.TypeReference;
import com.just.rocketmq.entity.OrderPaidEvent;
import com.just.rocketmq.entity.ProductWithPayload;
import com.just.rocketmq.entity.UserMsg;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQLocalRequestCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class MQProducerApplication implements CommandLineRunner {

	@Resource
	RocketMQTemplate rocketMQTemplate;

	@Resource(name = "extRocketMQTemplate")
	private RocketMQTemplate extRocketMQTemplate;

	@Value("${demo.rocketmq.topic}")
	private String springTopic;

	@Value("${demo.rocketmq.topic.user}")
	private String userTopic;

	@Value("${demo.rocketmq.transTopic}")
	private String springTransTopic;

	@Value("${demo.rocketmq.orderTopic}")
	private String orderPaidTopic;

	@Value("${demo.rocketmq.msgExtTopic}")
	private String msgExtTopic;

	@Value("${demo.rocketmq.stringRequestTopic}")
	private String stringRequestTopic;

	@Value("${demo.rocketmq.bytesRequestTopic}")
	private String bytesRequestTopic;

	@Value("${demo.rocketmq.objectRequestTopic}")
	private String objectRequestTopic;

	@Value("${demo.rocketmq.genericRequestTopic}")
	private String genericRequestTopic;


	public static void main(String[] args) {
		SpringApplication.run(MQProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
//发送String字符串
			SendResult sendResult = rocketMQTemplate.syncSend(springTopic, "Hello, World!");
			System.out.printf("syncSend1 to topic %s sendResult=%s %n", springTopic, sendResult);

			//发送对象
			UserMsg user = new UserMsg();
			user.setAge((byte) 10);
			user.setName("Just");
			sendResult = rocketMQTemplate.syncSend(userTopic, user);
			System.out.printf("syncSend1 to topic %s sendResult=%s %n", userTopic, sendResult);

			//Message 信息
			sendResult = rocketMQTemplate.syncSend(userTopic, MessageBuilder.withPayload(user).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE).build());
			System.out.printf("syncSend1 to topic %s sendResult=%s %n", userTopic, sendResult);

			// Use the extRocketMQTemplate
			sendResult = extRocketMQTemplate.syncSend(springTopic, MessageBuilder.withPayload("Hello, World!2222".getBytes()).build());
			System.out.printf("extRocketMQTemplate.syncSend1 to topic %s sendResult=%s %n", springTopic, sendResult);

			// Send string with spring Message
			sendResult = rocketMQTemplate.syncSend(springTopic, MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
			System.out.printf("syncSend2 to topic %s sendResult=%s %n", springTopic, sendResult);

			OrderPaidEvent orderPaidEvent = new OrderPaidEvent("T_001", new BigDecimal("88.00"));
			// Send user-defined object
			//异步发送-半事务消息
			rocketMQTemplate.asyncSend(orderPaidTopic, orderPaidEvent, new SendCallback() {
				@Override
				public void onSuccess(SendResult var1) {
					System.out.printf("async onSucess SendResult=%s %n", var1);
				}

				@Override
				public void onException(Throwable var1) {
					System.out.printf("async onException Throwable=%s %n", var1);
				}

			});

			// Send message with special tag 使用标签
			rocketMQTemplate.convertAndSend(msgExtTopic + ":tag0", "I'm from tag0");  // tag0 will not be consumer-selected
			System.out.printf("syncSend topic %s tag %s %n", msgExtTopic, "tag0");
			rocketMQTemplate.convertAndSend(msgExtTopic + ":tag1", "I'm from tag1");
			System.out.printf("syncSend topic %s tag %s %n", msgExtTopic, "tag1");


			//批量发送String
			testBatchMessage();

			//事务消息
			testTransaction();

			//同步发送 String类型
			// Send request in sync mode and receive a reply of String type.
			String replyString = rocketMQTemplate.sendAndReceive(stringRequestTopic, "request string", String.class);
			System.out.printf("send %s and receive %s %n", "request string", replyString);

			//同步发送 返回byte类型
			// Send request in sync mode with timeout parameter and receive a reply of byte[] type.
			byte[] replyBytes = rocketMQTemplate.sendAndReceive(bytesRequestTopic, MessageBuilder.withPayload("request byte[]").build(), byte[].class, 3000);
			System.out.printf("send %s and receive %s %n", "request byte[]", new String(replyBytes));

			// Send request in sync mode with hashKey parameter and receive a reply of User type.
			//同步发送 返回对象
			UserMsg requestUser = new UserMsg();
			requestUser.setAge((byte) 9);
			requestUser.setName("requestUserName");
			UserMsg replyUser = rocketMQTemplate.sendAndReceive(objectRequestTopic, requestUser, UserMsg.class, "order-id");
			System.out.printf("send %s and receive %s %n", requestUser, replyUser);

			//同步延时发送
			// Send request in sync mode with timeout and delayLevel parameter parameter and receive a reply of generic type.
			ProductWithPayload<String> replyGenericObject = rocketMQTemplate.sendAndReceive(genericRequestTopic, "request generic",
					new TypeReference<ProductWithPayload<String>>() {
					}.getType(), 30000, 2);
			System.out.printf("send %s and receive %s %n", "request generic", replyGenericObject);

			//异步发送，返回String类型
			// Send request in async mode and receive a reply of String type.
			rocketMQTemplate.sendAndReceive(stringRequestTopic, "request string", new RocketMQLocalRequestCallback<String>() {
				@Override public void onSuccess(String message) {
					System.out.printf("send %s and receive %s %n", "request string", message);
				}

				@Override public void onException(Throwable e) {
					e.printStackTrace();
				}
			});

			//异步发送返回对象
			// Send request in async mode and receive a reply of User type.
			rocketMQTemplate.sendAndReceive(objectRequestTopic, requestUser, new RocketMQLocalRequestCallback<UserMsg>() {
				@Override public void onSuccess(UserMsg message) {
					System.out.printf("send user object and receive %s %n", message.toString());
				}

				@Override public void onException(Throwable e) {
					e.printStackTrace();
				}
			}, 5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testBatchMessage() {
		List<Message> msgs = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			msgs.add(MessageBuilder.withPayload("Hello RocketMQ Batch Msg#" + i).
					setHeader(RocketMQHeaders.KEYS, "KEY_" + i).build());
		}
		SendResult sr = rocketMQTemplate.syncSend(springTopic, msgs, 60000);
		System.out.printf("--- Batch messages send result :" + sr);
	}

	public void testTransaction() {
		String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
		for (int i = 0; i < 10; i++) {
			try {
				Message msg = MessageBuilder.withPayload("rocket mq transactoinal message" + i)
						.setHeader(RocketMQHeaders.TRANSACTION_ID, "KEY_" + i)
						.build();
				SendResult sendResult = rocketMQTemplate.sendMessageInTransaction(springTransTopic
						+ ":" + tags[i % tags.length], msg, null);
				System.out.printf("------rocketMQTemplate send Transactional msg body = %s , sendResult=%s %n",
						msg.getPayload(), sendResult.getSendStatus());

				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
