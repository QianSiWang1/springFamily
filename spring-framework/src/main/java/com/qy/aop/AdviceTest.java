package com.qy.aop;

import com.qy.aop.advice.MyAfterReturningAdvice;
import com.qy.aop.service.BirdService;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class AdviceTest {
    public static void main(String[] args) {
        BirdService birdService = new BirdService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(birdService);
        proxyFactory.addAdvice(new MyAfterReturningAdvice());
        BirdService proxy = (BirdService) proxyFactory.getProxy();
        proxy.fly();

    }


}
