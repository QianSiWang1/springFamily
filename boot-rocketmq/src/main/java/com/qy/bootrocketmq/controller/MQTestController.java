package com.qy.bootrocketmq.controller;

import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ：楼兰
 * @description:
 **/
@RestController
@RequestMapping("/MQTest")
public class MQTestController {

    private final String topic = "test-topic";
    @Autowired
    RocketMQTemplate rocketMQTemplate;


    @RequestMapping("/sendMessage")
    public String sendMessage(String message){
        rocketMQTemplate.syncSend(topic,message);
        return "消息发送完成";
    }

    //这个发送事务消息的例子中有很多问题，需要注意下。
    @RequestMapping("/sendTransactionMessage")
    public String sendTransactionMessage(String message) throws InterruptedException {
        //producer.sendMessageInTransaction(topic,message);
        return "消息发送完成";
    }
}