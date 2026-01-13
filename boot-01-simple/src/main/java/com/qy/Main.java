package com.qy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;


@MapperScan(basePackages = "com.qy.mapper")
@SpringBootApplication
@EnableAsync
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);
        // 查看 ApplicationContext 类型
        System.out.println("ApplicationContext: " + run.getClass());
    }
}