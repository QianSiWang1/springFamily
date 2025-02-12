package com.qy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Value("${key:123}")
    private String value;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(value);
    }
}
