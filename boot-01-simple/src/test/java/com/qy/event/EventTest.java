package com.qy.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootTest
@EnableAsync
public class EventTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test1(){
        applicationContext.publishEvent(new OrderEvent("12321321312",123));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
