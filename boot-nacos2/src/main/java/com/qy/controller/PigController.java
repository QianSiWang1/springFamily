package com.qy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/pig")
public class PigController {

    @Value("${address:asdas}")
    private String userName;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Pig Service" + userName;
    }

}
