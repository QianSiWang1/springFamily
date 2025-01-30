package com.qy.aop.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerTest {
    /**
     * 前置通知
     */
    private static void before() {
        System.out.println("before method invoke...");
    }
    /**
     * 后置通知
     */
    private static void after() {
        System.out.println("after method invoke...");
    }
    /**
     * 异常通知
     */
    private static void exception() {
        System.out.println("exception method invoke...");
    }
    /**
     * 方法返回前通知
     */
    private static void beforeReturning() {
        System.out.println("beforeReturning method invoke...");
    }

    public static void main(String[] args) throws Exception {
        HelloWorld hello = new HelloWorld();
        //还有其他的回调方法，这里测试方法拦截器回调：MethodInterceptor
        HelloWorld proxyHW = (HelloWorld) Enhancer.create(hello.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                try {
                    //前置通知
                    before();
                    result = method.invoke(hello, objects);
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
        });
        String result = proxyHW.say(true);
        //String result = proxyHW.say(false);
        System.out.println(result);
    }
}
