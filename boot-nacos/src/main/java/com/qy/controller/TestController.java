package com.qy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${address}")
    private String userName;

    @GetMapping("/hello")
    public String hello() {
        return "Hello " + userName;
    }

}
