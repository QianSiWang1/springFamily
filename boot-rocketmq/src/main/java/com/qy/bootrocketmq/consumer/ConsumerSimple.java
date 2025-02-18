package com.qy.bootrocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "TestTopic",consumerGroup="test-consumer-group")
public class ConsumerSimple implements RocketMQListener<String> {
    @Override
    public void onMessage(String msg) {
        //此方法被调用表示接收到消息，msg形参就是消息内容
        //处理消息...
        System.out.println(msg);
    }
}