package com.qy.aop.aspect;


import org.springframework.stereotype.Component;

@Component
public class DogService {
    public void run() {
        System.out.println("dog run");
    }
}
