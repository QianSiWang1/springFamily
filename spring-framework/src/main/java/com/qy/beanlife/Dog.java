package com.qy.beanlife;


import lombok.Data;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class Dog {
    @PostConstruct
    public void init() {
        System.out.println("第一个init...");
    }

    // 有多个会执行多次
    @PostConstruct
    public void init1() {
        System.out.println("第二个init1...");
    }
}
