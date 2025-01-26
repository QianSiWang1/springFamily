package com.qy.beanlife;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if ("dogService".equals(beanName)) {
            System.out.println("MergedBeanDefinitionPostProcessor---被调用了");
            beanDefinition.getPropertyValues().add("dog", new Dog());
        }
    }
}
