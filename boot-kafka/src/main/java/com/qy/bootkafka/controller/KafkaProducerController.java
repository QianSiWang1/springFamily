package com.qy.bootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {
    @Autowired
    KafkaTemplate kafkaTemplate;

    @GetMapping("/sendMessage/{msg}")
    public void sendMsssage(@PathVariable("msg") String msg){
        kafkaTemplate.send("my-topic", "key", msg);
    }
}
