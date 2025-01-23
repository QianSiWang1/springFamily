package com.qy.bootkafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class myTopicListener {
    @KafkaListener(topics = "my-topic", groupId = "group-1")
    public void haha(ConsumerRecord record) {
        //1、获取消息的各种详细信息
//        String topic = record.topic();
        Object key = record.key();
        Object value = record.value();
        System.out.println("收到消息：key【" + key + "】 value【" + value + "】");
    }
}
