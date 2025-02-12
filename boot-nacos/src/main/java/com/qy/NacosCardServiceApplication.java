package com.qy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableFeignClients
public class NacosCardServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosCardServiceApplication.class, args);
    }
}