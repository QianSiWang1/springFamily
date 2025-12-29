package com.qy._01_ioc._09_inject._00_common;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author qy
 * @Date 2025/12/11
 */
public class _01_Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(_00_InjectComponentConfig.class);
        Object mapInject = applicationContext.getBean("_08_MapInject");
        System.out.println("_01_Start ===> _08_MapInject mapInject : " + mapInject);
    }
}
