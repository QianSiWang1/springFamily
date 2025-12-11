package com.qy._01_ioc._09_inject;

import com.qy._01_ioc._00_AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author qy
 * @Date 2025/12/11
 */
public class _01_Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(_00_InjectComponentConfig.class);
        applicationContext.close();
    }
}
