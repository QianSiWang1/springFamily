package com.qy.aop.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

public class InvocationHandlerTest {
    public static void main(String[] args) throws Exception {
        Animal cat = new Cat();
        /**
         * loader: 用哪个类加载器去加载代理对象
         * interfaces:动态代理类需要实现的接口
         * h:动态代理方法在执行时，会调用h里面的invoke方法去执行
         */
        Animal animal = (Animal) Proxy.newProxyInstance(cat.getClass().getClassLoader(), Cat.class.getInterfaces(), new AnimalInvocationHandler(cat));
        //animal.doWhat(true);
        animal.doWhat(false);
    }
}
