package com.qy.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        // 在每一个 Bean 初始化之前执行的方法（有多少 Bean 调用多少次）
//        // 注意 ： 启用该方法后，标注了@PostConstruct注解的方法会失效
//        System.out.println("初始化前置方法");
//        return null;
//    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //在每一个 Bean 初始化之后执行的方法（有多少 Bean 调用多少次）
        System.out.println("初始化后置方法");
        return null;
    }
}

