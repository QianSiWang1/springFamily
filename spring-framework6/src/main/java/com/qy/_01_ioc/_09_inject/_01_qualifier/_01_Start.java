package com.qy._01_ioc._09_inject._01_qualifier;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author qy
 * @Date 2025/12/11
 */
public class _01_Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(_00_QualifierComponentConfig.class);

    }
}
