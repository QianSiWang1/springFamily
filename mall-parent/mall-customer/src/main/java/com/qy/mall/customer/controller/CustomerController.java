package com.qy.mall.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    @RequestMapping("/hello")
    public String hello() {
        log.info("customer hello");
        return "customer hello";
    }
}
