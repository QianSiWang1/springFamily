package com.qy.beanlife;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.qy.beanlife")
@Component
public class AppConfig {
    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public InitMethodBean initMethodBean() {
        return new InitMethodBean();
    }
}
