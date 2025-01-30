package com.qy.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class MyThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, NullPointerException ex) {
        System.out.println("方法抛出异常后执行");
    }

}
