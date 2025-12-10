package com.qy._01_ioc;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author qy
 * @Date 2025/12/10
 */
@Component
public class _02_BeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization Bean名字是 【" + beanName + "】");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("BeanPostProcessor.postProcessAfterInitialization Bean名字是 【" + beanName + "】");
        return bean;
    }

}
