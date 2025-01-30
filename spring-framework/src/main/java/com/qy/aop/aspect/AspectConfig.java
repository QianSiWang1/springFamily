package com.qy.aop.aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@ComponentScan("com.qy.aop.aspect")
@Component
@EnableAspectJAutoProxy
public class AspectConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        DogService dogService = (DogService) context.getBean("dogService");
        dogService.run();
        context.close();
    }
}
