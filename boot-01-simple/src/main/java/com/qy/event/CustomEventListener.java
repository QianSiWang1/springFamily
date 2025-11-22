package com.qy.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomEventListener {

    @EventListener
    public void OrderEventListener(OrderEvent orderEvent){
        log.info("监听到了订单事件");
        System.out.println(orderEvent.getId());
        System.out.println(orderEvent.getNum());
    }
}
