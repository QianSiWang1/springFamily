package com.qy.aop.dynamicproxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalInvocationHandler implements InvocationHandler {

    private final Animal animal;

    public AnimalInvocationHandler(Animal animal) {
        this.animal = animal;
    }

    /**
     * - proxy：就是代理对象，newProxyInstance方法的返回对象
     * - method：调用的方法
     * - args: 方法中的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            //前置通知
            before();
            result = method.invoke(animal, args);
            //后置通知
            after();
        } catch (Exception e) {
            //异常通知
            exception();
        } finally {
            //方法返回前通知
            beforeReturning();
        }

        return result;

    }


    private void before() {
        System.out.println("before method invoke...");
    }

    private void after() {
        System.out.println("after method invoke...");
    }

    private void exception() {
        System.out.println("exception method invoke...");
    }

    private void beforeReturning() {
        System.out.println("beforeReturning method invoke...");
    }
}