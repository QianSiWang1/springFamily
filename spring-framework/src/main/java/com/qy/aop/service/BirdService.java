package com.qy.aop.service;

import org.springframework.stereotype.Component;

@Component
public class BirdService implements BirdInterface{
    public void fly() {
        System.out.println("bird fly");
    }
}
